package view;


import controller.MateriasDAO;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import model.Materias;
import javax.swing.table.DefaultTableModel;

public class FormPesquisaDeDisciplina extends javax.swing.JInternalFrame {

  
    public FormPesquisaDeDisciplina() {
        initComponents();
        configurarForm();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabDados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        tabDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabDadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabDados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pesquisa por nome de disciplina");

        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        String nome = txtNome.getText();
        
        if (nome.isEmpty()){
        //exibir todos os registros da tabela
            preencherTabela(new MateriasDAO().listar());
        }else{
            //pesquisar pelo nome
            preencherTabela(
                new MateriasDAO().pesquisarPorNome(nome)
            );
        }
    }//GEN-LAST:event_txtNomeKeyReleased

    private void tabDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabDadosMouseClicked
        // TODO add your handling code here:
                //verificar se o usuário clicou 2x
        if (evt.getClickCount() == 2){
            
            //recuperar o ID da categoria selecionada
            int linha = tabDados.getSelectedRow();
            String id = tabDados.getValueAt(linha, 0).toString();          
            
            //abrir o formulário de cadastro e centralizar na tela
            FormCadastroDeDisciplina f = new FormCadastroDeDisciplina(id);
            Dimension d = this.getDesktopPane().getSize();
            this.getDesktopPane().add(f);
            f.setLocation( (d.width-f.getSize().width)/2, (d.height-f.getSize().height)/2);
            f.setVisible(true);

            //fechar o formulário de pesquisa
            this.dispose();
        }
    }//GEN-LAST:event_tabDadosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabDados;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
    private void configurarForm(){
        this.setTitle("Pesquisa de Disciplinas");
        this.setResizable(false);
        this.setClosable(true);
        configurarTabela();
        preencherTabela(new MateriasDAO().listar());
    }
    
    private void configurarTabela(){
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.addColumn("Idêntificador da discilpina");
        m.addColumn("Nome disciplina");
        m.addColumn("Craga horaria");
        tabDados.setModel(m);
        tabDados.getColumnModel().getColumn(0).setPreferredWidth(30);
        tabDados.getColumnModel().getColumn(1).setPreferredWidth(100);
        tabDados.getColumnModel().getColumn(2).setPreferredWidth(30);
    }
        private void preencherTabela(List<Materias> lista) {

        if (lista != null) {
            if (lista.size() > 0) {
                configurarTabela();
                DefaultTableModel m = (DefaultTableModel)tabDados.getModel();
                for(Materias obj : lista){
                    m.addRow(new Object[]
                        {
                            obj.getId(),
                            obj.getNome_materia(),
                            obj.getCarga_horaria()
                        }
                    );
                }
                tabDados.setModel(m);
            } else {
                configurarTabela();
                JOptionPane.showMessageDialog(null, "A tabela não contém dados.", "Disciplinas da Escola",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } else {
            JOptionPane.showMessageDialog(null,"Ocorreu um erro.","ERRO",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
