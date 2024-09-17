
package Principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.MaskFormatter;










public class Janela extends JFrame{
    

    
    //TextField
private JTextField tNome;
private JTextField tEndereco;
private JTextField tTelefone;
private JTextField tCPF;
private JTextField tContatoEmergencia;
private JTextField tTelefone2;
private final JTextField tID;
    
    
    
    //Label
private final JLabel lNome;
private final JLabel lEndereco;
private final JLabel lTelefone;
private final JLabel lCPF; 
private final JLabel lTipoSangue;
private final JLabel lCurso;
private final JLabel lContatoEmergencia;
private final JLabel lTelefone2;
private final JLabel lID;
private final JLabel lPesquisa;
    
    
    
    
    //scrollPane
private final JTextArea sAreaPesquisa;
private final JScrollPane sPesquisa;
    
    
    
    //Buttons
private JButton Cadastrar;
private JButton Remover;
private JButton Pesquisar;
private JButton Alterar;
    
    

    //ComboBox
private final JComboBox cTipoSangue;
private final JComboBox cCurso;



    
    
//container
    
    
Container ctn;


    public Janela(){
    
        
        ctn = getContentPane();
        ctn.setLayout(null);
        
        
        
    //Janela e configuracoes basicas
    
   
    setSize(1300, 1000);
    setTitle("Titulo");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setLocationRelativeTo(null);
    setLayout(null);
    
    
    //Buttons
    Cadastrar = new JButton("Cadastrar");
    Cadastrar.setBounds(25, 840, 150, 50);
    Cadastrar.setFont(new Font("Arial", Font.BOLD, 20));
    
    
    Remover = new JButton("Remover");
    Remover.setBounds(25, 900, 150, 50);
    Remover.setFont(new Font("Arial", Font.BOLD, 20));
    
    
    Pesquisar = new JButton("Pesquisar");
    Pesquisar.setBounds(185, 900, 150, 50);
    Pesquisar.setFont(new Font("Arial", Font.BOLD, 20));
    
    
    Alterar = new JButton("Alterar");
    Alterar.setBounds(185, 840, 150, 50);
    Alterar.setFont(new Font("Arial", Font.BOLD, 20));
    
    
    
    ctn.add(Cadastrar);
    ctn.add(Remover);
    ctn.add(Pesquisar);
    ctn.add(Alterar);
    
    
    //Actions
    
    
    Cadastrar.addActionListener(this::Cadastrar);
    
    Remover.addActionListener(this::Remover);
    
    Alterar.addActionListener(this::Alterar);
    
    Pesquisar.addActionListener(this::Pesquisar);
    
    
    
    
    //TextFields
            
    //Nome
    tNome = new JTextField("");
    tNome.setBounds(200, 103, 170, 25);
    
    
    //Endereco
    tEndereco = new JTextField("");
    tEndereco.setBounds(200, 153, 170, 25);
    
    
    //Telefone com formatacao
    try {
        tTelefone = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
    } catch (ParseException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }
    tTelefone.setBounds(200, 203, 170, 25);
    
    
    //CPF com formatacao
    try {
        tCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
    } catch (ParseException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }
    tCPF.setBounds(200, 253, 170, 25);
    
    
    //Nome do contato de emergencia
    tContatoEmergencia = new JTextField("");
    tContatoEmergencia.setBounds(200, 403, 170, 25);
    
    
    //Numero do contato de emergencia
    try {
        tTelefone2 = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
    } catch (ParseException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }
    tTelefone2.setBounds(200, 453, 170, 25);
    
    
    //ID
    tID = new JTextField("");
    tID.setBounds(380, 913, 30, 25);
    

    
    
    ctn.add(tNome);
    ctn.add(tEndereco);
    ctn.add(tTelefone);
    ctn.add(tCPF);
    ctn.add(tContatoEmergencia);
    ctn.add(tTelefone2);
    ctn.add(tID);
    
    //ComboBox
    
    String[] Sangue={"A+","A-","B+","B-","AB+","AB-","O+","O-"};
    cTipoSangue = new JComboBox(Sangue);
    cTipoSangue.setSelectedIndex(0);
    cTipoSangue.setBounds(200, 303, 50, 25);
    
    
    String[] listaCurso={"Ciência da Computação","Medicina","Direito","Sistemas De Informação","Psicologia","Nutrição"};
    cCurso = new JComboBox(listaCurso);
    cCurso.setSelectedIndex(0);
    cCurso.setBounds(200, 353, 170, 25);
    
    
    
    
    
    ctn.add(cTipoSangue);
    ctn.add(cCurso);
    //JLabel
    
    
    lNome = new JLabel ("Nome:");
    lNome.setBounds(25, 100, 100, 30);
    
    lEndereco = new JLabel ("Endereço:");
    lEndereco.setBounds(25, 150, 100, 30);
    
    lTelefone = new JLabel ("Telefone:");
    lTelefone.setBounds(25, 200, 100, 30);
    
    lCPF = new JLabel ("CPF:");
    lCPF.setBounds(25, 250, 100, 30);
    
    lTipoSangue = new JLabel ("Tipo Sanguineo:");
    lTipoSangue.setBounds(25, 300, 100, 30);
    
    lCurso = new JLabel ("Curso:");
    lCurso.setBounds(25, 350, 100, 30);
    
    lContatoEmergencia = new JLabel ("Contato de Emergência:");
    lContatoEmergencia.setBounds(25, 400, 150, 30);
    
    lTelefone2 = new JLabel ("Segundo Telefone:");
    lTelefone2.setBounds(25, 450, 150, 30);
    
    lID = new JLabel ("ID:");
    lID.setBounds(350, 910, 30, 30);
    
    lPesquisa = new JLabel ("Resultados da Pesquisa:");
    lPesquisa.setBounds(500, 35, 150, 30);
    
    
    ctn.add(lNome);
    ctn.add(lEndereco);
    ctn.add(lTelefone);
    ctn.add(lCPF);
    ctn.add(lTipoSangue);
    ctn.add(lCurso);
    ctn.add(lContatoEmergencia);
    ctn.add(lTelefone2);
    ctn.add(lID);
    ctn.add(lPesquisa);
    
    
    
    
    //ScrollPane
    sAreaPesquisa = new JTextArea();
    sPesquisa = new JScrollPane(sAreaPesquisa);
    sPesquisa.setBounds(500, 60, 700, 800);
    
    
    ctn.add(sPesquisa);
    
    
    
    
    //ESSA BOSTA TEM QUE FICAR NO FINAL DO CODIGO
    setVisible(true);
    
    }

    //Cadastrar
    public void Cadastrar(ActionEvent CasdatrodeAluno){
    
       // JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Cadastrar", JOptionPane.INFORMATION_MESSAGE);
        Cadastro objeto = new Cadastro(tNome.getText(), tEndereco.getText(), tTelefone.getText(), tCPF.getText(), cTipoSangue.getSelectedItem().toString(), cCurso.getSelectedItem().toString(), tContatoEmergencia.getText(), tTelefone2.getText());
        
        try {
        Conexao objBanco = new Conexao();
        objBanco.inserirDados(objeto);
    } catch (SQLException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }


    
    
    
    }
    //Remover
    public void Remover(ActionEvent RemoverCadastro){
    try {
        Conexao objBanco = new Conexao();
        int ID = Integer.parseInt(tID.getText());
        objBanco.removerDados(ID);
    } catch (SQLException ex) {
        Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    
    }
    //Alterar
    public void Alterar(ActionEvent AlterarCadastro){
        Cadastro objeto = new Cadastro(tNome.getText(), tEndereco.getText(), tTelefone.getText(), tCPF.getText(), cTipoSangue.getSelectedItem().toString(), cCurso.getSelectedItem().toString(), tContatoEmergencia.getText(), tTelefone2.getText());
		
    try {
	Conexao objBanco = new Conexao();
	int ID = Integer.parseInt(tID.getText());
	objBanco.alterarDados(objeto, ID);
    } catch (SQLException e1) {
    }
            
            
            
    }
    //Pesquisar
    public void Pesquisar(ActionEvent PesquisarTabela){
    
    try {
	Conexao objBanco = new Conexao();
	ArrayList<String> relatorioBD = objBanco.Relatorio();	
	sAreaPesquisa.setText("");
            for(String texto: relatorioBD)
            {
	sAreaPesquisa.append(texto + "\n\n");
	}
    } catch (SQLException e1) {
}
    
    
    
    
    }
    
    
        
    }