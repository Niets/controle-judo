package controleatleta;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class CadastroJudoca extends javax.swing.JFrame {

    private final byte SEXO_MASCULINO_INDICE = 0;
    private final byte SEXO_FEMININO_INDICE = 1;
    private final char SEXO_MASCULINO_VALOR = 'M';
    private final char SEXO_FEMININO_VALOR = 'F';
    private final byte CATEGORIA_AMADOR_INDICE = 0;
    private final byte CATEGORIA_PROFISSIONAL_INDICE = 1;
    private final char CATEGORIA_AMADOR_VALOR = 'A';
    private final char CATEGORIA_PROFISSIONAL_VALOR = 'P';
    private final byte ESTILO_ORTODOXO_INDICE = 0;
    private final byte ESTILO_SOUTHPAW_INDICE = 1;
    private final char ESTILO_ORTODOXO_VALOR = 'O';
    private final char ESTILO_SOUTHPAW_VALOR = 'S';
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private ControleJudoca controleJudoca;
    private Judoca umJudoca;
    private boolean modoAlteracao;
    private boolean novoRegistro;
    private DefaultListModel telefonesListModel;
    private DefaultListModel premiacaoListModel;

    public CadastroJudoca() {
        initComponents();
        this.habilitarDesabilitarCampos();
        this.controleJudoca = new ControleJudoca();
        this.telefonesListModel = new DefaultListModel();
        this.jListTelefones.setModel(telefonesListModel);
        this.premiacaoListModel = new DefaultListModel();
        this.jListPremiacoes.setModel(premiacaoListModel);
        this.jTableListaJudocas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void limparCampos() {
        jTextFieldAltura.setText("0.0");
        jTextFieldBairro.setText(null);
        jTextFieldCategoriaPeso.setText(null);
        jTextFieldCep.setText(null);
        jTextFieldCidade.setText(null);
        jTextFieldComplemento.setText(null);
        jTextFieldCpf.setText(null);
        jTextFieldDataNascimento.setText(null);
        jTextFieldEnvergadura.setText("0.0");
        jComboBoxEstado.setSelectedIndex(0);
        jTextFieldLogradouro.setText(null);
        jTextFieldNome.setText(null);
        jTextFieldNomeMae.setText(null);
        jTextFieldNomePai.setText(null);
        jTextFieldNumero.setText("0");
        jTextFieldPais.setText(null);
        jTextFieldPeso.setText("0.0");
        jTextFieldRg.setText(null);
        jTextFieldTotalDerrotas.setText("0");
        jTextFieldTotalEstrangulamentos.setText("0");
        jTextFieldTotalLutas.setText("0");
        jTextFieldTotalIppon.setText("0");
        jTextFieldTotalVitorias.setText("0");
        telefonesListModel.clear();
        premiacaoListModel.clear();
        jComboBoxSexo.setSelectedIndex(0);
        jComboBoxCategoria.setSelectedIndex(0);
        jComboBoxEstilo.setSelectedIndex(0);
        this.atualizarCategoriaPeso();
    }

    private void preencherCampos() {
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;

        jTextFieldAltura.setText(Double.toString(umJudoca.getAltura()));
        jTextFieldBairro.setText(umJudoca.getEndereco().getBairro());
        jTextFieldCategoriaPeso.setText(Double.toString(umJudoca.getPeso()));
        jTextFieldCep.setText(umJudoca.getEndereco().getCep());
        jTextFieldCidade.setText(umJudoca.getEndereco().getCidade());
        jTextFieldComplemento.setText(umJudoca.getEndereco().getComplemento());
        jTextFieldCpf.setText(umJudoca.getCpf());
        if (umJudoca.getDataNascimento() == null) {
            jTextFieldDataNascimento.setText(null);
        } else {
            jTextFieldDataNascimento.setText(dateFormat.format(umJudoca.getDataNascimento()));
        }
        jTextFieldEnvergadura.setText(Double.toString(umJudoca.getEnvergadura()));
        jComboBoxEstado.setSelectedItem(umJudoca.getEndereco().getEstado());
        jTextFieldLogradouro.setText(umJudoca.getEndereco().getLogradouro());
        jTextFieldNome.setText(umJudoca.getNome());
        jTextFieldNomeMae.setText(umJudoca.getNomeMae());
        jTextFieldNomePai.setText(umJudoca.getNomePai());
        jTextFieldNumero.setText(umJudoca.getEndereco().getNumero().toString());
        jTextFieldPais.setText(umJudoca.getEndereco().getPais());
        jTextFieldPeso.setText(Double.toString(umJudoca.getPeso()));
        jTextFieldRg.setText(umJudoca.getRg());
        jTextFieldTotalDerrotas.setText(Integer.toString(umJudoca.getTotalDerrotas()));
        jTextFieldTotalEstrangulamentos.setText(Integer.toString(umJudoca.getTotalEstrangulamento()));
        jTextFieldTotalLutas.setText(Integer.toString(umJudoca.getTotalLutas()));
        jTextFieldTotalIppon.setText(Integer.toString(umJudoca.getTotalVitoriasIppon()));
        jTextFieldTotalVitorias.setText(Integer.toString(umJudoca.getTotalVitorias()));

        telefonesListModel.clear();
        telefones = umJudoca.getTelefones();
        for (String t : telefones) {
            telefonesListModel.addElement(t);
        }

        premiacaoListModel.clear();
        premiacoes = umJudoca.getPremiacoes();
        for (Premiacao p : premiacoes) {
            premiacaoListModel.addElement(p);
        }

        switch (umJudoca.getSexo()) {
            case SEXO_MASCULINO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_MASCULINO_INDICE);
                break;
            case SEXO_FEMININO_VALOR:
                jComboBoxSexo.setSelectedIndex(SEXO_FEMININO_INDICE);
                break;
        }

        switch (umJudoca.getCategoria()) {
            case CATEGORIA_AMADOR_VALOR:
                jComboBoxCategoria.setSelectedIndex(CATEGORIA_AMADOR_INDICE);
                break;
            case CATEGORIA_PROFISSIONAL_VALOR:
                jComboBoxCategoria.setSelectedIndex(CATEGORIA_PROFISSIONAL_INDICE);
                break;
        }

        switch (umJudoca.getEstilo()) {
            case ESTILO_ORTODOXO_VALOR:
                jComboBoxEstilo.setSelectedIndex(ESTILO_ORTODOXO_INDICE);
                break;
            case ESTILO_SOUTHPAW_VALOR:
                jComboBoxEstilo.setSelectedIndex(ESTILO_SOUTHPAW_INDICE);
                break;
        }

        this.atualizarCategoriaPeso();
    }

    private boolean validarCampos() {
        if (jTextFieldNome.getText().trim().length() == 0) {
            this.exibirInformacao("O valor do campo 'Nome' não foi informado.");
            jTextFieldNome.requestFocus();
            return false;
        }
        if (jTextFieldDataNascimento.getText().length() != 0) {
            try {
                dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                this.exibirInformacao("O valor do campo 'Data de Nascimento' é inválido.");
                jTextFieldDataNascimento.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(jTextFieldAltura.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Altura' é inválido.");
            jTextFieldAltura.requestFocus();
            return false;
        }
        try {
            Double.parseDouble(jTextFieldPeso.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Peso' é inválido.");
            jTextFieldPeso.requestFocus();
            return false;
        }
        if (!jTextFieldNumero.getText().equals("")) {
            try {
                Integer.parseInt(jTextFieldNumero.getText());
            } catch (Exception ex) {
                this.exibirInformacao("O valor do campo 'Número' é inválido.");
                jTextFieldNumero.requestFocus();
                return false;
            }
        }
        try {
            Double.parseDouble(jTextFieldEnvergadura.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Envergadura' é inválido.");
            jTextFieldEnvergadura.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalDerrotas.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Derrotas' é inválido.");
            jTextFieldTotalDerrotas.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalEstrangulamentos.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Estrangulamentos' é inválido.");
            jTextFieldTotalEstrangulamentos.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalLutas.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Lutas' é inválido.");
            jTextFieldTotalLutas.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalIppon.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Ippons' é inválido.");
            jTextFieldTotalIppon.requestFocus();
            return false;
        }
        try {
            Integer.parseInt(jTextFieldTotalVitorias.getText());
        } catch (Exception ex) {
            this.exibirInformacao("O valor do campo 'Total de Vitórias' é inválido.");
            jTextFieldTotalVitorias.requestFocus();
            return false;
        }
        return true;
    }

    private void habilitarDesabilitarCampos() {
        boolean registroSelecionado = (umJudoca != null);
        jTextFieldAltura.setEnabled(modoAlteracao);
        jTextFieldBairro.setEnabled(modoAlteracao);
        jTextFieldCategoriaPeso.setEnabled(false);
        jTextFieldCep.setEnabled(modoAlteracao);
        jTextFieldCidade.setEnabled(modoAlteracao);
        jTextFieldComplemento.setEnabled(modoAlteracao);
        jTextFieldCpf.setEnabled(modoAlteracao);
        jTextFieldDataNascimento.setEnabled(modoAlteracao);
        jTextFieldEnvergadura.setEnabled(modoAlteracao);
        jComboBoxEstado.setEnabled(modoAlteracao);
        jTextFieldLogradouro.setEnabled(modoAlteracao);
        jTextFieldNome.setEnabled(modoAlteracao);
        jTextFieldNomeMae.setEnabled(modoAlteracao);
        jTextFieldNomePai.setEnabled(modoAlteracao);
        jTextFieldNumero.setEnabled(modoAlteracao);
        jTextFieldPais.setEnabled(modoAlteracao);
        jTextFieldPeso.setEnabled(modoAlteracao);
        jTextFieldRg.setEnabled(modoAlteracao);
        jTextFieldTotalDerrotas.setEnabled(modoAlteracao);
        jTextFieldTotalEstrangulamentos.setEnabled(modoAlteracao);
        jTextFieldTotalLutas.setEnabled(modoAlteracao);
        jTextFieldTotalIppon.setEnabled(modoAlteracao);
        jTextFieldTotalVitorias.setEnabled(modoAlteracao);
        jButtonNovo.setEnabled(modoAlteracao == false);
        jButtonAlterar.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonExcluir.setEnabled(modoAlteracao == false && registroSelecionado == true);
        jButtonPesquisar.setEnabled(modoAlteracao == false);
        jButtonSalvar.setEnabled(modoAlteracao);
        jButtonCancelar.setEnabled(modoAlteracao);
        jButtonAdicionarTelefone.setEnabled(modoAlteracao);
        jButtonRemoverTelefone.setEnabled(modoAlteracao);
        jButtonAdicionarPremiacao.setEnabled(modoAlteracao);
        jButtonRemoverPremiacao.setEnabled(modoAlteracao);
        jComboBoxSexo.setEnabled(modoAlteracao);
        jComboBoxCategoria.setEnabled(modoAlteracao);
        jComboBoxEstilo.setEnabled(modoAlteracao);
        jTableListaJudocas.setEnabled(modoAlteracao == false);
    }

    private void salvarRegistro() {
        Endereco endereco;
        ArrayList<String> telefones;
        ArrayList<Premiacao> premiacoes;
        Date dataNascimento;

        if (this.validarCampos() == false) {
            return;
        }

        if (jTextFieldDataNascimento.getText().length() == 0) {
            dataNascimento = null;
        } else {
            try {
                dataNascimento = dateFormat.parse(jTextFieldDataNascimento.getText());
            } catch (ParseException ex) {
                exibirInformacao("Falha ao gravar a data de nascimento: " + ex.toString());
                return;
            }
        }

        endereco = new Endereco();
        endereco.setBairro(jTextFieldBairro.getText());
        endereco.setCep(jTextFieldCep.getText());
        endereco.setCidade(jTextFieldCidade.getText());
        endereco.setComplemento(jTextFieldComplemento.getText());
        endereco.setEstado((String) jComboBoxEstado.getSelectedItem());
        endereco.setLogradouro(jTextFieldLogradouro.getText());
        endereco.setNumero(jTextFieldNumero.getText());
        endereco.setPais(jTextFieldPais.getText());

        telefones = new ArrayList<String>();
        for (int i = 0; i < telefonesListModel.size(); i++) {
            telefones.add(telefonesListModel.getElementAt(i).toString());
        }

        premiacoes = new ArrayList<Premiacao>();
        for (int i = 0; i < premiacaoListModel.size(); i++) {
            Premiacao premiacao = (Premiacao) premiacaoListModel.getElementAt(i);
            premiacoes.add(premiacao);
        }

        if (novoRegistro == true) {
            umJudoca = new Judoca(jTextFieldNome.getText());
        } else {
            umJudoca.setNome(jTextFieldNome.getText());
        }
        umJudoca.setEndereco(endereco);
        umJudoca.setTelefones(telefones);
        umJudoca.setPremiacoes(premiacoes);
        umJudoca.setDataNascimento(dataNascimento);
        umJudoca.setAltura(Double.parseDouble(jTextFieldAltura.getText()));
        umJudoca.setNomeMae(jTextFieldNomeMae.getText());
        umJudoca.setNomePai(jTextFieldNomePai.getText());
        umJudoca.setPeso(Double.parseDouble(jTextFieldPeso.getText()));
        umJudoca.setCpf(jTextFieldCpf.getText());
        umJudoca.setRg(jTextFieldRg.getText());
        umJudoca.setEnvergadura(Double.parseDouble(jTextFieldEnvergadura.getText()));
        umJudoca.setTotalDerrotas(Integer.parseInt(jTextFieldTotalDerrotas.getText()));
        umJudoca.setTotalEstrangulamento(Integer.parseInt(jTextFieldTotalEstrangulamentos.getText()));
        umJudoca.setTotalLutas(Integer.parseInt(jTextFieldTotalLutas.getText()));
        umJudoca.setTotalVitoriasIppon(Integer.parseInt(jTextFieldTotalIppon.getText()));
        umJudoca.setTotalVitorias(Integer.parseInt(jTextFieldTotalVitorias.getText()));

        switch (jComboBoxSexo.getSelectedIndex()) {
            case SEXO_MASCULINO_INDICE:
                umJudoca.setSexo(SEXO_MASCULINO_VALOR);
                break;
            case SEXO_FEMININO_INDICE:
                umJudoca.setSexo(SEXO_FEMININO_VALOR);
                break;
        }

        switch (jComboBoxCategoria.getSelectedIndex()) {
            case CATEGORIA_AMADOR_INDICE:
                umJudoca.setCategoria(CATEGORIA_AMADOR_VALOR);
                break;
            case CATEGORIA_PROFISSIONAL_INDICE:
                umJudoca.setCategoria(CATEGORIA_PROFISSIONAL_VALOR);
                break;
        }

        switch (jComboBoxEstilo.getSelectedIndex()) {
            case ESTILO_ORTODOXO_INDICE:
                umJudoca.setEstilo(ESTILO_ORTODOXO_VALOR);
                break;
            case ESTILO_SOUTHPAW_INDICE:
                umJudoca.setEstilo(ESTILO_SOUTHPAW_VALOR);
                break;
        }

        if (novoRegistro == true) {
            controleJudoca.adicionar(umJudoca);
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.carregarListaBoxeadores();
        this.habilitarDesabilitarCampos();
    }

    private void carregarListaBoxeadores() {
        ArrayList<Judoca> listaBoxeadores = controleJudoca.getListaJudocas();
        DefaultTableModel model = (DefaultTableModel) jTableListaJudocas.getModel();
        model.setRowCount(0);
        for (Judoca b : listaBoxeadores) {
            model.addRow(new String[]{b.getNome(), b.getCpf()});
        }
        jTableListaJudocas.setModel(model);
    }

    private void exibirInformacao(String info) {
        JOptionPane.showMessageDialog(this, info, "Atenção", JOptionPane.INFORMATION_MESSAGE);
    }

    private void atualizarCategoriaPeso() {
        char categoria;
        switch (jComboBoxCategoria.getSelectedIndex()) {
            case CATEGORIA_AMADOR_INDICE:
                categoria = CATEGORIA_AMADOR_VALOR;
                break;
            case CATEGORIA_PROFISSIONAL_INDICE:
                categoria = CATEGORIA_PROFISSIONAL_VALOR;
                break;
            default:
                return;
        }
        jTextFieldCategoriaPeso.setText(Judoca.obterCategoriaPesoNome(categoria, Double.parseDouble(jTextFieldPeso.getText())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonNovo = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelAltura = new javax.swing.JLabel();
        jTextFieldAltura = new javax.swing.JTextField();
        jTextFieldPeso = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jTextFieldNomePai = new javax.swing.JTextField();
        jLabelNomePai = new javax.swing.JLabel();
        jTextFieldNomeMae = new javax.swing.JTextField();
        jLabelNomeMae = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jLabelRg = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelTelefones = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTelefones = new javax.swing.JList();
        jButtonAdicionarTelefone = new javax.swing.JButton();
        jButtonRemoverTelefone = new javax.swing.JButton();
        jComboBoxSexo = new javax.swing.JComboBox();
        jTextFieldDataNascimento = new javax.swing.JTextField();
        jTextFieldRg = new javax.swing.JTextField();
        jTextFieldCpf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelLogradouro = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabelBairro = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabelCidade = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jLabelPais = new javax.swing.JLabel();
        jTextFieldPais = new javax.swing.JTextField();
        jLabelComplemento = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelCep = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox();
        jTextFieldCep = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabelCategoria = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox();
        jLabelCategoriaPeso = new javax.swing.JLabel();
        jLabelEstilo = new javax.swing.JLabel();
        jComboBoxEstilo = new javax.swing.JComboBox();
        jTextFieldEnvergadura = new javax.swing.JTextField();
        jLabelEnvergadura = new javax.swing.JLabel();
        jLabelTotalLutas = new javax.swing.JLabel();
        jTextFieldTotalLutas = new javax.swing.JTextField();
        jTextFieldTotalVitorias = new javax.swing.JTextField();
        jLabelTotalVitorias = new javax.swing.JLabel();
        jTextFieldTotalIppon = new javax.swing.JTextField();
        jLabelTotalVitoriasNocaute = new javax.swing.JLabel();
        jTextFieldTotalEstrangulamentos = new javax.swing.JTextField();
        jLabelTotalEstrangulamento = new javax.swing.JLabel();
        jLabelTotalDerrotas = new javax.swing.JLabel();
        jTextFieldTotalDerrotas = new javax.swing.JTextField();
        jTextFieldCategoriaPeso = new javax.swing.JTextField();
        jLabelPremiacoes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListPremiacoes = new javax.swing.JList();
        jButtonAdicionarPremiacao = new javax.swing.JButton();
        jButtonRemoverPremiacao = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jLabelListaJudocas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableListaJudocas = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jLabelNome.setText("Nome:");

        jLabelDataNascimento.setText("Data de Nascimento:");

        jLabelAltura.setText("Altura:");

        jTextFieldPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesoActionPerformed(evt);
            }
        });
        jTextFieldPeso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPesoFocusLost(evt);
            }
        });
        jTextFieldPeso.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldPesoPropertyChange(evt);
            }
        });

        jLabelPeso.setText("Peso:");

        jLabelNomePai.setText("Nome do Pai:");

        jLabelNomeMae.setText("Nome da Mãe:");

        jLabelSexo.setText("Sexo:");

        jLabelRg.setText("RG:");

        jLabelCpf.setText("CPF:");

        jLabelTelefones.setText("Telefones:");

        jListTelefones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListTelefones);

        jButtonAdicionarTelefone.setText("+");
        jButtonAdicionarTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarTelefoneActionPerformed(evt);
            }
        });

        jButtonRemoverTelefone.setText("-");
        jButtonRemoverTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverTelefoneActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));

        jTextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataNascimentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRg, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelSexo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAdicionarTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRemoverTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCpf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldRg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabelNomePai, jLabelSexo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDataNascimento)
                            .addComponent(jTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSexo)
                            .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPeso))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAltura)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomePai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomePai))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeMae))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRg)
                    .addComponent(jTextFieldRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCpf)
                    .addComponent(jTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTelefones)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonAdicionarTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoverTelefone))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(95, 95, 95))
        );

        jTabbedPane1.addTab("Informações Gerais", jPanel1);

        jLabelLogradouro.setText("Logradouro:");

        jLabelNumero.setText("Número:");

        jLabelBairro.setText("Bairro:");

        jLabelCidade.setText("Cidade:");

        jLabelEstado.setText("Estado:");

        jLabelPais.setText("País:");

        jLabelComplemento.setText("Complemento:");

        jLabelCep.setText("CEP:");

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelPais, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelCep, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabelLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldPais, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabelLogradouro)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelComplemento)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBairro)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCidade)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPais)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCep)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(133, 133, 133))
        );

        jTabbedPane1.addTab("Endereço", jPanel2);

        jLabelCategoria.setText("Categoria:");

        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Amador", "Profissional" }));
        jComboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaActionPerformed(evt);
            }
        });

        jLabelCategoriaPeso.setText("Categoria (Peso):");

        jLabelEstilo.setText("Estilo:");

        jComboBoxEstilo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ortodoxo (destro)", "Southpaw (canhoto)" }));
        jComboBoxEstilo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstiloActionPerformed(evt);
            }
        });

        jLabelEnvergadura.setText("Envergadura:");

        jLabelTotalLutas.setText("Total de Lutas:");

        jLabelTotalVitorias.setText("Total de Vitórias:");

        jLabelTotalVitoriasNocaute.setText("Total de Vitórias por Ippon:");

        jTextFieldTotalEstrangulamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalEstrangulamentosActionPerformed(evt);
            }
        });

        jLabelTotalEstrangulamento.setText("Vitórias por  Estrangulamentos:");

        jLabelTotalDerrotas.setText("Total de Derrotas:");

        jTextFieldCategoriaPeso.setEnabled(false);

        jLabelPremiacoes.setText("Premiações:");

        jScrollPane2.setViewportView(jListPremiacoes);

        jButtonAdicionarPremiacao.setText("+");
        jButtonAdicionarPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarPremiacaoActionPerformed(evt);
            }
        });

        jButtonRemoverPremiacao.setText("-");
        jButtonRemoverPremiacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverPremiacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEnvergadura)
                    .addComponent(jLabelCategoria)
                    .addComponent(jLabelCategoriaPeso)
                    .addComponent(jLabelEstilo)
                    .addComponent(jLabelTotalLutas)
                    .addComponent(jLabelTotalVitorias)
                    .addComponent(jLabelTotalVitoriasNocaute)
                    .addComponent(jLabelTotalEstrangulamento)
                    .addComponent(jLabelTotalDerrotas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotalDerrotas, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalEstrangulamentos, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalIppon, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalVitorias, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalLutas, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldEnvergadura, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jComboBoxEstilo, 0, 193, Short.MAX_VALUE)
                    .addComponent(jTextFieldCategoriaPeso, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                    .addComponent(jComboBoxCategoria, 0, 193, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPremiacoes)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonRemoverPremiacao, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                            .addComponent(jButtonAdicionarPremiacao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCategoria)
                            .addComponent(jLabelPremiacoes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCategoriaPeso)
                            .addComponent(jTextFieldCategoriaPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEstilo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEnvergadura)
                            .addComponent(jTextFieldEnvergadura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalLutas)
                            .addComponent(jTextFieldTotalLutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalVitorias)
                            .addComponent(jTextFieldTotalVitorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalVitoriasNocaute)
                            .addComponent(jTextFieldTotalIppon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalEstrangulamento)
                            .addComponent(jTextFieldTotalEstrangulamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTotalDerrotas)
                            .addComponent(jTextFieldTotalDerrotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonAdicionarPremiacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemoverPremiacao))
                            .addComponent(jScrollPane2))))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ficha Técnica", jPanel3);

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonPesquisar.setText("Pesquisar...");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabelListaJudocas.setText("Lista de Judocas:");

        jTableListaJudocas.setModel(new javax.swing.table.DefaultTableModel 
            (
                null,
                new String [] {
                    "Nome", "CPF"
                }
            )
            {
                @Override    
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            });
            jTableListaJudocas.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTableListaJudocasMouseClicked(evt);
                }
            });
            jScrollPane4.setViewportView(jTableListaJudocas);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelListaJudocas)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonAlterar)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonExcluir)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonPesquisar)
                            .addGap(222, 222, 222)
                            .addComponent(jButtonSalvar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonAlterar, jButtonCancelar, jButtonExcluir, jButtonNovo, jButtonPesquisar, jButtonSalvar});

            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNovo)
                        .addComponent(jButtonAlterar)
                        .addComponent(jButtonExcluir)
                        .addComponent(jButtonPesquisar)
                        .addComponent(jButtonSalvar)
                        .addComponent(jButtonCancelar))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelListaJudocas)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaActionPerformed
        this.atualizarCategoriaPeso();
    }//GEN-LAST:event_jComboBoxCategoriaActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        umJudoca = null;
        modoAlteracao = true;
        novoRegistro = true;
        this.limparCampos();
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        this.salvarRegistro();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        if (novoRegistro == true) {
            this.limparCampos();
        } else {
            this.preencherCampos();
        }
        modoAlteracao = false;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesoActionPerformed
    }//GEN-LAST:event_jTextFieldPesoActionPerformed

    private void jTextFieldPesoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldPesoPropertyChange
    }//GEN-LAST:event_jTextFieldPesoPropertyChange

    private void jTextFieldPesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPesoFocusLost
        this.atualizarCategoriaPeso();
    }//GEN-LAST:event_jTextFieldPesoFocusLost

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        modoAlteracao = true;
        novoRegistro = false;
        this.habilitarDesabilitarCampos();
        this.jTextFieldNome.requestFocus();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        this.controleJudoca.remover(umJudoca);
        umJudoca = null;
        this.limparCampos();
        this.carregarListaBoxeadores();
        this.habilitarDesabilitarCampos();
    }//GEN-LAST:event_jButtonExcluirActionPerformed

private void jButtonAdicionarTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarTelefoneActionPerformed
    CadastroTelefone cadastro = new CadastroTelefone(this, true);
    cadastro.setVisible(true);
    if (cadastro.getTelefone() != null) {
        telefonesListModel.addElement(cadastro.getTelefone());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarTelefoneActionPerformed

private void jButtonRemoverTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverTelefoneActionPerformed
    if (jListTelefones.getSelectedIndex() != -1) {
        telefonesListModel.removeElementAt(jListTelefones.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverTelefoneActionPerformed

private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    String pesquisa = JOptionPane.showInputDialog("Informe o nome do Judoca.");
    if (pesquisa != null) {
        this.pesquisarBoxeador(pesquisa);
    }
}//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void pesquisarBoxeador(String nome) {
        Judoca boxeadorPesquisado = controleJudoca.pesquisar(nome);

        if (boxeadorPesquisado == null) {
            exibirInformacao("Judoca não encontrado.");
        } else {
            this.umJudoca = boxeadorPesquisado;
            this.preencherCampos();
            this.habilitarDesabilitarCampos();
        }
    }

private void jButtonAdicionarPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarPremiacaoActionPerformed
    CadastroPremiacao cadastro = new CadastroPremiacao(this, true);
    cadastro.setVisible(true);
    if (cadastro.getPremiacao() != null) {
        premiacaoListModel.addElement(cadastro.getPremiacao());
    }
    cadastro.dispose();
}//GEN-LAST:event_jButtonAdicionarPremiacaoActionPerformed

private void jButtonRemoverPremiacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverPremiacaoActionPerformed
    if (jListPremiacoes.getSelectedIndex() != -1) {
        premiacaoListModel.removeElementAt(jListPremiacoes.getSelectedIndex());
    }
}//GEN-LAST:event_jButtonRemoverPremiacaoActionPerformed

private void jTableListaJudocasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListaJudocasMouseClicked
    if (jTableListaJudocas.isEnabled()) {
        DefaultTableModel model = (DefaultTableModel) jTableListaJudocas.getModel();
        String nome = (String) model.getValueAt(jTableListaJudocas.getSelectedRow(), 0);
        this.pesquisarBoxeador(nome);
    }
}//GEN-LAST:event_jTableListaJudocasMouseClicked

private void jTextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataNascimentoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldDataNascimentoActionPerformed

private void jComboBoxEstiloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstiloActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBoxEstiloActionPerformed

private void jTextFieldTotalEstrangulamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalEstrangulamentosActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldTotalEstrangulamentosActionPerformed

private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jComboBoxEstadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarPremiacao;
    private javax.swing.JButton jButtonAdicionarTelefone;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemoverPremiacao;
    private javax.swing.JButton jButtonRemoverTelefone;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxCategoria;
    private javax.swing.JComboBox jComboBoxEstado;
    private javax.swing.JComboBox jComboBoxEstilo;
    private javax.swing.JComboBox jComboBoxSexo;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCategoria;
    private javax.swing.JLabel jLabelCategoriaPeso;
    private javax.swing.JLabel jLabelCep;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEnvergadura;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelEstilo;
    private javax.swing.JLabel jLabelListaJudocas;
    private javax.swing.JLabel jLabelLogradouro;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeMae;
    private javax.swing.JLabel jLabelNomePai;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelPais;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPremiacoes;
    private javax.swing.JLabel jLabelRg;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefones;
    private javax.swing.JLabel jLabelTotalDerrotas;
    private javax.swing.JLabel jLabelTotalEstrangulamento;
    private javax.swing.JLabel jLabelTotalLutas;
    private javax.swing.JLabel jLabelTotalVitorias;
    private javax.swing.JLabel jLabelTotalVitoriasNocaute;
    private javax.swing.JList jListPremiacoes;
    private javax.swing.JList jListTelefones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableListaJudocas;
    private javax.swing.JTextField jTextFieldAltura;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCategoriaPeso;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldDataNascimento;
    private javax.swing.JTextField jTextFieldEnvergadura;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeMae;
    private javax.swing.JTextField jTextFieldNomePai;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPais;
    private javax.swing.JTextField jTextFieldPeso;
    private javax.swing.JTextField jTextFieldRg;
    private javax.swing.JTextField jTextFieldTotalDerrotas;
    private javax.swing.JTextField jTextFieldTotalEstrangulamentos;
    private javax.swing.JTextField jTextFieldTotalIppon;
    private javax.swing.JTextField jTextFieldTotalLutas;
    private javax.swing.JTextField jTextFieldTotalVitorias;
    // End of variables declaration//GEN-END:variables
}
