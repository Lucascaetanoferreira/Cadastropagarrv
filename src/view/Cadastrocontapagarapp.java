package view;
import Br.edu.model.Contapagar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cadastrocontapagarapp {
    private JTextField fornecedorField;
    private JTextField valorField;
    private JTextField dataVencimentoField;
    private JComboBox<String> statusComboBox;
    private JTable tabela;
    private DefaultTableModel tabelaModel;
    private ArrayList<Contapagar> contas;

    public Cadastrocontapagarapp() {

        setTitle("Cadastro de Contas a Pagar");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        contas = new ArrayList<Contapagar>();


        setLayout(new BorderLayout());


        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));

        formPanel.add(new JLabel("Fornecedor:"));
        fornecedorField = new JTextField();
        formPanel.add(fornecedorField);

        formPanel.add(new JLabel("Valor:"));
        valorField = new JTextField();
        formPanel.add(valorField);

        formPanel.add(new JLabel("Data de Vencimento:"));
        dataVencimentoField = new JTextField("dd/MM/yyyy");
        formPanel.add(dataVencimentoField);

        formPanel.add(new JLabel("Status:"));
        String[] statusOptions = {"Pago", "Pendente"};
        statusComboBox = new JComboBox<>(statusOptions);
        formPanel.add(statusComboBox);

        JButton cadastrarButton = new JButton("Cadastrar");
        formPanel.add(cadastrarButton);


        tabelaModel = new DefaultTableModel(new Object[]{"Fornecedor", "Valor", "Data Vencimento", "Status"}, 0);
        tabela = new JTable(tabelaModel);
        JScrollPane tableScroll = new JScrollPane(tabela);




        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarConta();
            }
        });
    }

    private void cadastrarConta() {
        try {
            String fornecedor = fornecedorField.getText();
            double valor = Double.parseDouble(valorField.getText());
            String dataVencimento = dataVencimentoField.getText();
            String status = (String) statusComboBox.getSelectedItem();


            Contapagar conta = new Contapagar(fornecedor, valor, dataVencimento, status);
            contas.add(conta);

            tabelaModel.addRow(new Object[]{fornecedor, valor, dataVencimento, status});
            limparCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar conta. Verifique os dados informados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        fornecedorField.setText("");
        valorField.setText("");
        dataVencimentoField.setText("dd/MM/yyyy");
        statusComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Cadastrocontapagarapp app = new Cadastrocontapagarapp();
            app.setVisible(true);
        });
    }

    private void setVisible(boolean b) {
    }
}


