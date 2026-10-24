
package com.br.senac.fichastecnicas;

import view.TelaListagem;
import javax.swing.SwingUtilities;

public class FichasTecnicasEtapa6 {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaListagem tela = new TelaListagem();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        });

    }
}
