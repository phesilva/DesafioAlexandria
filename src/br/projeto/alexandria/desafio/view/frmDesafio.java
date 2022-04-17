package br.projeto.alexandria.desafio.view;

import br.projeto.alexandria.desafio.control.TabelaControl;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/*Phelipe A.*/
public class frmDesafio extends javax.swing.JFrame{
	
	//construtor da classe
	public frmDesafio() {
		initComponents();
	}
	@SuppressWarnings("unchecked")
	private void initComponents() {
		//seletor de arquivos
		jFileChooser1 = new javax.swing.JFileChooser();
		//botao para iniciar o desafio
		 btnIniciar = new javax.swing.JButton();
		 
		 //labels com icon da empresa
	     jLabel2 = new javax.swing.JLabel();
	     jLabel1 = new javax.swing.JLabel();
	     //textfield para receber a url
	     txtNomeScript = new javax.swing.JTextField();
	     
	     //botao que inicializa o seletor de arquivos
	     btnProcurarArquivo = new javax.swing.JButton();
	     
	     setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	     
	     btnIniciar.setText("Iniciar");
	        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnIniciarActionPerformed(evt);
	            }
	        });
	        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/projeto/alexandria/desafio/view/iconalexandria.png"))); // NOI18N
	        jLabel2.setText("jLabel2");

	        jLabel1.setText("Arquivo .SQL a ser executado");
	        
	        btnProcurarArquivo.setText("Procurar Arquivo");
	        btnProcurarArquivo.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                btnProcurarArquivoActionPerformed(evt);
	            }
	        });
	        
	        
	        //layout
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	       //setando o layout e o tipo
	        getContentPane().setLayout(layout);
	        //organizando horizontalmente
	        layout.setHorizontalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(layout.createSequentialGroup()
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(158, 158, 158)
	                            .addComponent(jLabel1))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(38, 38, 38)
	                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                .addGroup(layout.createSequentialGroup()
	                                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
	                                    .addGap(18, 18, 18)
	                                    .addComponent(btnProcurarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
	                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                        .addGroup(layout.createSequentialGroup()
	                            .addGap(54, 54, 54)
	                            .addComponent(txtNomeScript, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                    .addContainerGap(27, Short.MAX_VALUE))
	            );
	        
	        //organizando verticalmente
	        layout.setVerticalGroup(
	                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                    .addGap(22, 22, 22)
	                    .addComponent(jLabel2)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
	                    .addComponent(jLabel1)
	                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                    .addComponent(txtNomeScript, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGap(37, 37, 37)
	                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addComponent(btnProcurarArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGap(40, 40, 40))
	            );	        
	        pack();   
	}

	//metodos para as ações
	private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        TabelaControl objtabelacontrol = new TabelaControl();
        try {
            objtabelacontrol.executeSqlScript(txtNomeScript.getText().toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    //botao para procurar o arquivo pelo seletor de arquivos
    private void btnProcurarArquivoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        //objeto do tipo seletor de arquivos
        JFileChooser fc = new JFileChooser();
        //aceitar apenas arquivos
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //onde ele ira abrir, ou seja no proprio botão
        fc.showOpenDialog(this);
        //variavel do tipo file, para receber o arquivo
        File f = fc.getSelectedFile();
        //pegar o url do arquivo e passar pra textField
        txtNomeScript.setText(f.getPath());
    }
	
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDesafio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* cria e mostra a tela*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDesafio().setVisible(true);
            }
        });
    }
    
    
	private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnProcurarArquivo;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtNomeScript;
}
