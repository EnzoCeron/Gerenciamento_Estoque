package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


import Model.Usuario;
import com.amazonaws.regions.Regions;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.*;


public class UsuarioDAO {

    private final Conexao conexao;
    private String query;
    private PreparedStatement ps;
    //Cadastro e Login de Usuario, via Cognito
    private final String USER_POOL_ID = "us-east-2_pEEvvUKHm";
    private final String CLIENT_ID = "66g36clem57321e4gc195ppijq";
    private final Map<String, String> authparams = new HashMap<>();

    public UsuarioDAO() {
        this.conexao = Conexao.getInstancia();
    }


    AWSCognitoIdentityProvider cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
            .withRegion(Regions.US_EAST_2)
            .build();

    //Funcao de verificacao de email dentro do banco
    private boolean verificarEmailExistente(String email) {
        this.query = "SELECT EXISTS(SELECT * FROM usuario WHERE email = ?)";
        try {
            this.ps = conexao.getCon().prepareStatement(query);
            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //Funcao de Cadastro de Usuario
    public void inserirUsuario(Usuario usuario) {
        try {
            if (verificarEmailExistente(usuario.getEmail())) {
                System.out.println("\n");
                System.out.println("Email ja esta cadastrado no banco de dados \n");
            } else {
                this.query = "INSERT INTO usuario (email, nome, senha) VALUES (?, ?, ?)";
                this.ps = this.conexao.getCon().prepareStatement(query);
                this.ps.setString(1, usuario.getEmail());
                this.ps.setString(2, usuario.getNome());
                this.ps.setString(3, usuario.getSenha());
                this.ps.executeUpdate();
                System.out.println("\n");
                System.out.println("Usuario cadastrado com sucesso!");
                this.ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        SignUpRequest singnUpRequest = new SignUpRequest()
                .withClientId(CLIENT_ID)
                .withUsername(usuario.getEmail())
                .withPassword(usuario.getSenha());

        SignUpResult result = cognitoClient.signUp(singnUpRequest);
        System.out.println("Usuario cadastrado com sucesso no Cognito. Status:" + result.getUserConfirmed());
    }

    //Funcao de Login de Usuario
    public boolean LoginUsuario(Usuario usuario) {
        authparams.put("USERNAME", usuario.getEmail());
        authparams.put("PASSWORD", usuario.getSenha());
        try{
            InitiateAuthRequest authRequest = new InitiateAuthRequest()
                    .withAuthFlow(AuthFlowType.USER_PASSWORD_AUTH)
                    .withAuthParameters(authparams)
                    .withClientId(CLIENT_ID);


            InitiateAuthResult authResponse = cognitoClient.initiateAuth(authRequest);
            AuthenticationResultType authResult = authResponse.getAuthenticationResult();

            if (authResult != null) {
                System.out.println("Usuario logado com sucesso no Cognito");
            } else {
                System.out.println("Usuario ou senha invalidos, no cognito");
            }

            this.query = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
            this.ps = this.conexao.getCon().prepareStatement(query);
            this.ps.setString(1, usuario.getEmail());
            this.ps.setString(2, usuario.getSenha());
            ResultSet rs = this.ps.executeQuery();
            return rs.next(); // Retorna True se encontrar um usuario correspondente
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }catch (NotAuthorizedException e){
            System.out.println("Usuario ou senha invalidos");
            return false;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //Funcao de Listar Usuarios
    public ResultSet listarUsuarios() {
        try {
            this.query = "SELECT * FROM usuario";
            this.ps = this.conexao.getCon().prepareStatement(query);
            return this.ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void excluirUsuario(Usuario usuario) {
        try {

            if (verificarEmailExistente(usuario.getEmail())) {
                String query = "DELETE FROM usuario WHERE email = ?";
                PreparedStatement ps = this.conexao.getCon().prepareStatement(query);
                ps.setString(1, usuario.getEmail());


                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Usuário excluído com sucesso.");
                } else {
                    System.out.println("Nenhum usuário encontrado com o email fornecido.");
                }
            } else {
                System.out.println("Email não existe no banco.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

