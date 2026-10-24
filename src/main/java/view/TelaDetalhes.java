
package view;

import model.FichaTecnica;
import com.br.senac.util.Conexao;
import javax.swing.table.DefaultTableModel;
import model.Produto;
import repository.ProdutoRepository;
import repository.FichaTecnicaRepository;
import service.ProdutoService;
import service.FichaTecnicaService;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.FichaTecnicaDetalhe;

public class TelaDetalhes extends javax.swing.JFrame {
    
    
    private final ProdutoService produtoService =
            new ProdutoService(new ProdutoRepository());

    private final FichaTecnicaService fichaService =
            new FichaTecnicaService(new FichaTecnicaRepository());

    private FichaTecnica fichaAtual;
    private int id;
    private int idFicha;    

    public TelaDetalhes(int id) {
        initComponents();
        this.id = id;
        this.fichaAtual = new FichaTecnica();

        carregarProduto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNome = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnAdicionarProcesso = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDetalhes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Detalhes da Ficha Técnica");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Produto");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblCategoriaActionPerformed(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAdicionarProcesso.setText("Adicionar");
        btnAdicionarProcesso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarProcessoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Categoria");

        tabelaDetalhes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Composição Tecido", "Tipo de costura", "Processo de Fabricação"
            }
        ));
        jScrollPane1.setViewportView(tabelaDetalhes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(btnAdicionarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(252, 252, 252))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(341, 341, 341)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarProcesso, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblCategoriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaListagem tela = new TelaListagem();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdicionarProcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarProcessoActionPerformed
        TelaCadastroDetalhe tela = new TelaCadastroDetalhe(idFicha, this);
        tela.setVisible(true);
    }//GEN-LAST:event_btnAdicionarProcessoActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDetalhes(1).setVisible(true);
            }
        });
    }
    

    public void carregarProduto() {

        try {
            Produto produto = produtoService.buscarPorId(id);

            if (produto == null) {
                JOptionPane.showMessageDialog(
                    this,
                    "Produto não encontrado."
                );
                return;
            }

            lblNome.setText(produto.getNome());
            lblCategoria.setText(produto.getCategoria());

            idFicha = fichaService.obterOuCriarFicha(id);

            carregarFichaTecnica(idFicha);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar produto: " + e.getMessage()
            );
        }
    }
    
    public void carregarFichaTecnica(int idFicha) {

        DefaultTableModel modelo =
                (DefaultTableModel) tabelaDetalhes.getModel();

        modelo.setRowCount(0);

        try {
            FichaTecnicaDetalhe ficha =
                    fichaService.buscarPorId(idFicha);

            if (ficha != null) {

                modelo.addRow(new Object[]{
                    ficha.getComposicaoTecido(),
                    ficha.getTipoCostura(),
                    ficha.getProcessoFabricacao()
                });

            } else {
                JOptionPane.showMessageDialog(
                    this,
                    "Ficha técnica não encontrada."
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                this,
                "Erro ao carregar ficha técnica: "
                        + e.getMessage()
            );
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarProcesso;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblCategoria;
    private javax.swing.JTextField lblNome;
    private javax.swing.JTable tabelaDetalhes;
    // End of variables declaration//GEN-END:variables
}
