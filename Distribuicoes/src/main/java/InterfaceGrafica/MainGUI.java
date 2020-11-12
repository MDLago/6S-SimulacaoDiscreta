/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import FuncoesDistribuicoes.Calculo;
import FuncoesDistribuicoes.D_Exponencial;
import FuncoesDistribuicoes.D_Normal;
import FuncoesDistribuicoes.D_Triangular;
import FuncoesDistribuicoes.D_Uniforme;
import FuncoesDistribuicoes.Distribuicoes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

/**
 *
 * @author marco
 */
public class MainGUI extends javax.swing.JFrame {
    
    private enum TIPO{
        TS,TEC
    }
  
    Calculo calc_TS, calc_TEC;
    
    JPanel tempJP_TS = new JPanel();
    JPanel tempJP_TEC = new JPanel();
    
    int tempoMaximo;
    /**
     * Creates new form Main
     */
    public MainGUI() {
        initComponents();
        preencherCB();
        inicializar();
        
    }
    
    public void inicializar(){      
        
        f_ExpOff_TS.setEditable(false);
        f_ExpOff_TEC.setEditable(false);
        
        b_Simular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                tempoMaximo = Integer.valueOf(tf_TempoMaximo.getText());
                
                String str = cb_TEC.getSelectedItem().toString();
                Distribuicoes disTEC = Distribuicoes.valueOf(str.toUpperCase());
                
                str = cb_TS.getSelectedItem().toString();
                Distribuicoes disTS = Distribuicoes.valueOf(str.toUpperCase());
                
                calc_TS = getCalculo(disTS, TIPO.TS);
                calc_TEC = getCalculo(disTEC, TIPO.TEC);
                
                Simulacao simulacao = new Simulacao(calc_TS, calc_TEC, tempoMaximo);
                simulacao.setVisible(true);
            }
        });
        
        cb_TEC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = cb_TEC.getSelectedItem().toString();
                Distribuicoes dis = Distribuicoes.valueOf(str.toUpperCase());
                switch (dis){
                    case DETERMINISTICO: 
                        habilitarTela(Distribuicoes.DETERMINISTICO,TIPO.TEC);
                        break;
                    case EXPONENCIAL:
                        habilitarTela(Distribuicoes.EXPONENCIAL,TIPO.TEC);
                        break;
                    case NORMAL:
                        habilitarTela(Distribuicoes.NORMAL,TIPO.TEC);
                        break;
                    case TRIANGULAR:
                        habilitarTela(Distribuicoes.TRIANGULAR,TIPO.TEC);
                        break;
                    case UNIFORME:;
                        habilitarTela(Distribuicoes.UNIFORME,TIPO.TEC);
                }
                
                atualizarTela();
            }
        });
        
        cb_TS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = cb_TS.getSelectedItem().toString();
                Distribuicoes dis = Distribuicoes.valueOf(str.toUpperCase());
                switch (dis){
                    case DETERMINISTICO: 
                        habilitarTela(Distribuicoes.DETERMINISTICO,TIPO.TS);
                        break;
                    case EXPONENCIAL:
                        habilitarTela(Distribuicoes.EXPONENCIAL,TIPO.TS);
                        break;
                    case NORMAL:
                        habilitarTela(Distribuicoes.NORMAL,TIPO.TS);
                        break;
                    case TRIANGULAR:
                        habilitarTela(Distribuicoes.TRIANGULAR,TIPO.TS);
                        break;
                    case UNIFORME:;
                        habilitarTela(Distribuicoes.UNIFORME,TIPO.TS);
                }
                
                atualizarTela();
            }
        }); 
        
        chb_ExpOff_TS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Utils.valorJCB(chb_ExpOff_TS)){
                    f_ExpOff_TS.setEditable(true);
                }else{
                    f_ExpOff_TS.setEditable(false);
                }
            }
        });
        
        chb_ExpOff_TEC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Utils.valorJCB(chb_ExpOff_TEC)){
                    f_ExpOff_TEC.setEditable(true);
                }else{
                    f_ExpOff_TEC.setEditable(false);
                }
            }
        });
    }
    
    public void preencherCB(){
        cb_TEC.setModel(new DefaultComboBoxModel<>(Distribuicoes.values()));
        cb_TS.setModel(new DefaultComboBoxModel<>(Distribuicoes.values()));
       
        cb_TEC.setSelectedIndex(-1);
        cb_TS.setSelectedIndex(-1);
    }
    
    public void atualizarTela(){
        this.repaint();
        
    }
    
    public void habilitarTela(Distribuicoes d, TIPO tipo){
        JPanel jpTS, jpTEC;
        switch(d){
            case DETERMINISTICO: 
                 jpTS = jP_deterministicoTS;
                 jpTEC = jP_deterministicoTEC;
                if(tipo == TIPO.TS){
                    setFalseTS();
                    panel_ParametroTS.remove(tempJP_TS);
                    this.tempJP_TS = jpTS;
                    panel_ParametroTS.add(tempJP_TS);
                    this.tempJP_TS.setVisible(true);
                }else{
                    setFalseTEC();
                    panel_ParametroTEC.remove(tempJP_TEC);
                    this.tempJP_TEC = jpTEC;
                    panel_ParametroTEC.add(tempJP_TEC);
                    this.tempJP_TEC.setVisible(true);
                }
                break;
            case EXPONENCIAL:
                 jpTS = jP_exponencialTS;
                 jpTEC = jP_exponencialTEC;
                if(tipo == TIPO.TS){
                    setFalseTS();
                    panel_ParametroTS.remove(tempJP_TS);
                    this.tempJP_TS = jpTS;
                    panel_ParametroTS.add(tempJP_TS);
                    this.tempJP_TS.setVisible(true);
                }else{
                    setFalseTEC();
                    panel_ParametroTEC.remove(tempJP_TEC);
                    this.tempJP_TEC = jpTEC;
                    panel_ParametroTEC.add(tempJP_TEC);
                    this.tempJP_TEC.setVisible(true);
                }
                break;
            case NORMAL:
                 jpTS = jP_normalTS;
                 jpTEC = jP_normalTEC;
                if(tipo == TIPO.TS){
                    setFalseTS();
                    panel_ParametroTS.remove(tempJP_TS);
                    this.tempJP_TS = jpTS;
                    panel_ParametroTS.add(tempJP_TS);
                    this.tempJP_TS.setVisible(true);
                }else{
                    setFalseTEC();
                    panel_ParametroTEC.remove(tempJP_TEC);
                    this.tempJP_TEC = jpTEC;
                    panel_ParametroTEC.add(tempJP_TEC);
                    this.tempJP_TEC.setVisible(true);
                }
                break;
            case TRIANGULAR:
                 jpTS = jP_triangularTS;
                 jpTEC = jP_triangularTEC;
                if(tipo == TIPO.TS){
                    setFalseTS();
                    panel_ParametroTS.remove(tempJP_TS);
                    this.tempJP_TS = jpTS;
                    panel_ParametroTS.add(tempJP_TS);
                    this.tempJP_TS.setVisible(true);
                }else{
                    setFalseTEC();
                    panel_ParametroTEC.remove(tempJP_TEC);
                    this.tempJP_TEC = jpTEC;
                    panel_ParametroTEC.add(tempJP_TEC);
                    this.tempJP_TEC.setVisible(true);
                }
                break;
            case UNIFORME:
                 jpTS = jP_uniformeTS;
                 jpTEC = jP_uniformeTEC;
                if(tipo == TIPO.TS){
                    setFalseTS();
                    panel_ParametroTS.remove(tempJP_TS);
                    this.tempJP_TS = jpTS;
                    panel_ParametroTS.add(tempJP_TS);
                    this.tempJP_TS.setVisible(true);
                }else{
                    setFalseTEC();
                    panel_ParametroTEC.remove(tempJP_TEC);
                    this.tempJP_TEC = jpTEC;
                    panel_ParametroTEC.add(tempJP_TEC);
                    this.tempJP_TEC.setVisible(true);
                }
                break;
        }
    }

    
    public void setFalseTS(){
        this.tempJP_TS.setVisible(false);
    }
    public void setFalseTEC(){
        this.tempJP_TEC.setVisible(false);
    }
    
    public Calculo getCalculo(Distribuicoes tip, TIPO tip2){
        Calculo calc;
        
        
        switch(tip){
            case DETERMINISTICO:
                double valor;
                
                if(tip2 == TIPO.TS){
                    valor = Utils.valorJTF_Double(f_DetVal_TS);
                }else{
                    valor = Utils.valorJTF_Double(f_DetVal_TEC);
                }
                
                calc = new Calculo(valor, 0, 0, 0) {
                        @Override
                        public double gerarNumero() {
                            return a;
                        }
                    };
                return calc;
                
            case EXPONENCIAL:
                double mediaExp;
                double offset = 0;
                double offsetON = 0;
                        
                if(tip2 == TIPO.TS){
                    mediaExp = Utils.valorJTF_Double(f_ExpMed_TS);
                    
                    if(Utils.valorJCB(chb_ExpOff_TS)){
                        offsetON = 1;
                        offset = Utils.valorJTF_Double(f_ExpOff_TS);    
                    }
                }else{
                    mediaExp = Utils.valorJTF_Double(f_ExpMed_TEC);
                    
                    if(Utils.valorJCB(chb_ExpOff_TEC)){
                        offsetON = 1;
                        offset = Utils.valorJTF_Double(f_ExpOff_TEC);
                    }
                }
                
                calc = D_Exponencial.getD_Exponencial(mediaExp, offset,offsetON,0);
                        
                return calc;
                
            case NORMAL:
                double mediaNor, desvio;
                
                if(tip2 == TIPO.TS){
                    mediaNor = Utils.valorJTF_Double(f_NorMed_TS);
                    desvio = Utils.valorJTF_Double(f_NorDes_TS);
                }else{
                    mediaNor = Utils.valorJTF_Double(f_NorMed_TEC);
                    desvio = Utils.valorJTF_Double(f_NorDes_TEC);
                }
                
                calc = D_Normal.getD_Normal(mediaNor, desvio,0,0);
                
                return calc;
            case TRIANGULAR:
                double minimo, maximo, moda;
                
                if(tip2 == TIPO.TS){
                    minimo = Utils.valorJTF_Double(f_TriMin_TS);
                    maximo = Utils.valorJTF_Double(f_TriMax_TS);
                    moda = Utils.valorJTF_Double(f_TriMod_TS);
                }else{
                    minimo = Utils.valorJTF_Double(f_TriMin_TEC);
                    maximo = Utils.valorJTF_Double(f_TriMax_TEC);
                    moda = Utils.valorJTF_Double(f_TriMod_TEC);
                }
                calc = D_Triangular.getD_Triangular(minimo, maximo,moda,0);
                
                return calc;
            case UNIFORME:
                double minimoUni, maximoUni;
                
                if(tip2 == TIPO.TS){
                    minimoUni = Utils.valorJTF_Double(f_UniMin_TS);
                    maximoUni = Utils.valorJTF_Double(f_UniMax_TS);
                }else{
                    minimoUni = Utils.valorJTF_Double(f_UniMin_TEC);
                    maximoUni = Utils.valorJTF_Double(f_UniMax_TEC);
                }
                
                calc = D_Uniforme.getD_Uniforme(minimoUni, maximoUni,0,0);
                
                return calc;
            default:
                return null;
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jP_uniformeTS = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        f_UniMin_TS = new javax.swing.JTextField();
        f_UniMax_TS = new javax.swing.JTextField();
        jP_exponencialTS = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        f_ExpMed_TS = new javax.swing.JTextField();
        f_ExpOff_TS = new javax.swing.JTextField();
        chb_ExpOff_TS = new javax.swing.JCheckBox();
        jP_normalTS = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        f_NorMed_TS = new javax.swing.JTextField();
        f_NorDes_TS = new javax.swing.JTextField();
        jP_triangularTS = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        f_TriMin_TS = new javax.swing.JTextField();
        f_TriMax_TS = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        f_TriMod_TS = new javax.swing.JTextField();
        jP_deterministicoTS = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        f_DetVal_TS = new javax.swing.JTextField();
        jP_uniformeTEC = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        f_UniMin_TEC = new javax.swing.JTextField();
        f_UniMax_TEC = new javax.swing.JTextField();
        jP_exponencialTEC = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        f_ExpMed_TEC = new javax.swing.JTextField();
        f_ExpOff_TEC = new javax.swing.JTextField();
        chb_ExpOff_TEC = new javax.swing.JCheckBox();
        jP_normalTEC = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        f_NorMed_TEC = new javax.swing.JTextField();
        f_NorDes_TEC = new javax.swing.JTextField();
        jP_triangularTEC = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        f_TriMin_TEC = new javax.swing.JTextField();
        f_TriMax_TEC = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        f_TriMod_TEC = new javax.swing.JTextField();
        jP_deterministicoTEC = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        f_DetVal_TEC = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 60), new java.awt.Dimension(10, 60), new java.awt.Dimension(10, 60));
        jLabel1 = new javax.swing.JLabel();
        tf_TempoMaximo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_TEC = new javax.swing.JComboBox();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cb_TS = new javax.swing.JComboBox();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        panel_Parametros = new javax.swing.JPanel();
        panel_ParametroTEC = new javax.swing.JPanel();
        panel_TituloParametroTEC = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 210), new java.awt.Dimension(10, 210), new java.awt.Dimension(10, 210));
        panel_ParametroTS = new javax.swing.JPanel();
        panel_TituloParametroTS = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        b_Simular = new javax.swing.JButton();

        jP_uniformeTS.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_uniformeTS.setMinimumSize(new java.awt.Dimension(216, 166));
        jP_uniformeTS.setPreferredSize(new java.awt.Dimension(216, 166));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel5.setText("Minimo: ");

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel6.setText("Maximo: ");

        f_UniMin_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_UniMin_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_UniMin_TS.setName(""); // NOI18N
        f_UniMin_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        f_UniMax_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_UniMax_TS.setMaximumSize(new java.awt.Dimension(100, 20));
        f_UniMax_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_UniMax_TS.setName(""); // NOI18N
        f_UniMax_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_uniformeTSLayout = new javax.swing.GroupLayout(jP_uniformeTS);
        jP_uniformeTS.setLayout(jP_uniformeTSLayout);
        jP_uniformeTSLayout.setHorizontalGroup(
            jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_uniformeTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_UniMin_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_UniMax_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_uniformeTSLayout.setVerticalGroup(
            jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_uniformeTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(f_UniMin_TS, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jP_uniformeTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jP_uniformeTSLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(f_UniMax_TS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );

        jP_exponencialTS.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_exponencialTS.setMinimumSize(new java.awt.Dimension(216, 166));
        jP_exponencialTS.setPreferredSize(new java.awt.Dimension(216, 166));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel8.setText("Média:");

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setText("Offset (x0): ");

        f_ExpMed_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_ExpMed_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_ExpMed_TS.setName(""); // NOI18N
        f_ExpMed_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        f_ExpOff_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_ExpOff_TS.setMaximumSize(new java.awt.Dimension(100, 20));
        f_ExpOff_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_ExpOff_TS.setName(""); // NOI18N
        f_ExpOff_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        chb_ExpOff_TS.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        chb_ExpOff_TS.setText("Definir Offset?");

        javax.swing.GroupLayout jP_exponencialTSLayout = new javax.swing.GroupLayout(jP_exponencialTS);
        jP_exponencialTS.setLayout(jP_exponencialTSLayout);
        jP_exponencialTSLayout.setHorizontalGroup(
            jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_exponencialTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chb_ExpOff_TS)
                    .addGroup(jP_exponencialTSLayout.createSequentialGroup()
                        .addGroup(jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_ExpOff_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_ExpMed_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_exponencialTSLayout.setVerticalGroup(
            jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_exponencialTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(f_ExpMed_TS, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_exponencialTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(f_ExpOff_TS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chb_ExpOff_TS)
                .addGap(64, 64, 64))
        );

        jP_normalTS.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_normalTS.setMinimumSize(new java.awt.Dimension(216, 166));
        jP_normalTS.setPreferredSize(new java.awt.Dimension(216, 166));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel13.setText("Média:");

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel14.setText("Desvio:");

        f_NorMed_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_NorMed_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_NorMed_TS.setName(""); // NOI18N
        f_NorMed_TS.setPreferredSize(new java.awt.Dimension(100, 20));
        f_NorMed_TS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_NorMed_TSActionPerformed(evt);
            }
        });

        f_NorDes_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_NorDes_TS.setMaximumSize(new java.awt.Dimension(100, 20));
        f_NorDes_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_NorDes_TS.setName(""); // NOI18N
        f_NorDes_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_normalTSLayout = new javax.swing.GroupLayout(jP_normalTS);
        jP_normalTS.setLayout(jP_normalTSLayout);
        jP_normalTSLayout.setHorizontalGroup(
            jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_normalTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addGap(27, 27, 27)
                .addGroup(jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_NorDes_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_NorMed_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jP_normalTSLayout.setVerticalGroup(
            jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_normalTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(f_NorMed_TS, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_normalTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(f_NorDes_TS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        jP_triangularTS.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_triangularTS.setMinimumSize(new java.awt.Dimension(216, 166));
        jP_triangularTS.setPreferredSize(new java.awt.Dimension(216, 166));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel16.setText("Minimo: ");

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel17.setText("Maximo: ");

        f_TriMin_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMin_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMin_TS.setName(""); // NOI18N
        f_TriMin_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        f_TriMax_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMax_TS.setMaximumSize(new java.awt.Dimension(100, 20));
        f_TriMax_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMax_TS.setName(""); // NOI18N
        f_TriMax_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel18.setText("Moda:");

        f_TriMod_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMod_TS.setMaximumSize(new java.awt.Dimension(100, 20));
        f_TriMod_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMod_TS.setName(""); // NOI18N
        f_TriMod_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_triangularTSLayout = new javax.swing.GroupLayout(jP_triangularTS);
        jP_triangularTS.setLayout(jP_triangularTSLayout);
        jP_triangularTSLayout.setHorizontalGroup(
            jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_triangularTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_triangularTSLayout.createSequentialGroup()
                        .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(27, 27, 27)
                        .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_TriMax_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_TriMin_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_TriMod_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel18))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_triangularTSLayout.setVerticalGroup(
            jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_triangularTSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(f_TriMin_TS, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(f_TriMax_TS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_triangularTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(f_TriMod_TS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jP_deterministicoTS.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_deterministicoTS.setMinimumSize(new java.awt.Dimension(216, 166));
        jP_deterministicoTS.setPreferredSize(new java.awt.Dimension(216, 166));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setText("Valor:");

        f_DetVal_TS.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_DetVal_TS.setMinimumSize(new java.awt.Dimension(100, 20));
        f_DetVal_TS.setName(""); // NOI18N
        f_DetVal_TS.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_deterministicoTSLayout = new javax.swing.GroupLayout(jP_deterministicoTS);
        jP_deterministicoTS.setLayout(jP_deterministicoTSLayout);
        jP_deterministicoTSLayout.setHorizontalGroup(
            jP_deterministicoTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_deterministicoTSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(f_DetVal_TS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jP_deterministicoTSLayout.setVerticalGroup(
            jP_deterministicoTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_deterministicoTSLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jP_deterministicoTSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(f_DetVal_TS, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        jP_uniformeTEC.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_uniformeTEC.setMinimumSize(new java.awt.Dimension(216, 166));

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel10.setText("Minimo: ");

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel12.setText("Maximo: ");

        f_UniMin_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_UniMin_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_UniMin_TEC.setName(""); // NOI18N
        f_UniMin_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        f_UniMax_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_UniMax_TEC.setMaximumSize(new java.awt.Dimension(100, 20));
        f_UniMax_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_UniMax_TEC.setName(""); // NOI18N
        f_UniMax_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_uniformeTECLayout = new javax.swing.GroupLayout(jP_uniformeTEC);
        jP_uniformeTEC.setLayout(jP_uniformeTECLayout);
        jP_uniformeTECLayout.setHorizontalGroup(
            jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_uniformeTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_UniMin_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_UniMax_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_uniformeTECLayout.setVerticalGroup(
            jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_uniformeTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(f_UniMin_TEC, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jP_uniformeTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jP_uniformeTECLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(f_UniMax_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );

        jP_exponencialTEC.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_exponencialTEC.setMinimumSize(new java.awt.Dimension(216, 166));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel15.setText("Média:");

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel19.setText("Offset (x0): ");

        f_ExpMed_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_ExpMed_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_ExpMed_TEC.setName(""); // NOI18N
        f_ExpMed_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        f_ExpOff_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_ExpOff_TEC.setMaximumSize(new java.awt.Dimension(100, 20));
        f_ExpOff_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_ExpOff_TEC.setName(""); // NOI18N
        f_ExpOff_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        chb_ExpOff_TEC.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        chb_ExpOff_TEC.setText("Definir Offset?");

        javax.swing.GroupLayout jP_exponencialTECLayout = new javax.swing.GroupLayout(jP_exponencialTEC);
        jP_exponencialTEC.setLayout(jP_exponencialTECLayout);
        jP_exponencialTECLayout.setHorizontalGroup(
            jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_exponencialTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chb_ExpOff_TEC)
                    .addGroup(jP_exponencialTECLayout.createSequentialGroup()
                        .addGroup(jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_ExpOff_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_ExpMed_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_exponencialTECLayout.setVerticalGroup(
            jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_exponencialTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(f_ExpMed_TEC, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_exponencialTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(f_ExpOff_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chb_ExpOff_TEC)
                .addGap(64, 64, 64))
        );

        jP_normalTEC.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_normalTEC.setMinimumSize(new java.awt.Dimension(216, 166));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel20.setText("Média:");

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel21.setText("Desvio:");

        f_NorMed_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_NorMed_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_NorMed_TEC.setName(""); // NOI18N
        f_NorMed_TEC.setPreferredSize(new java.awt.Dimension(100, 20));
        f_NorMed_TEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f_NorMed_TECActionPerformed(evt);
            }
        });

        f_NorDes_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_NorDes_TEC.setMaximumSize(new java.awt.Dimension(100, 20));
        f_NorDes_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_NorDes_TEC.setName(""); // NOI18N
        f_NorDes_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_normalTECLayout = new javax.swing.GroupLayout(jP_normalTEC);
        jP_normalTEC.setLayout(jP_normalTECLayout);
        jP_normalTECLayout.setHorizontalGroup(
            jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_normalTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(27, 27, 27)
                .addGroup(jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(f_NorDes_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f_NorMed_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jP_normalTECLayout.setVerticalGroup(
            jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_normalTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(f_NorMed_TEC, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_normalTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(f_NorDes_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        jP_triangularTEC.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_triangularTEC.setMinimumSize(new java.awt.Dimension(216, 166));

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel22.setText("Minimo: ");

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel23.setText("Maximo: ");

        f_TriMin_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMin_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMin_TEC.setName(""); // NOI18N
        f_TriMin_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        f_TriMax_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMax_TEC.setMaximumSize(new java.awt.Dimension(100, 20));
        f_TriMax_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMax_TEC.setName(""); // NOI18N
        f_TriMax_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel24.setText("Moda:");

        f_TriMod_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_TriMod_TEC.setMaximumSize(new java.awt.Dimension(100, 20));
        f_TriMod_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_TriMod_TEC.setName(""); // NOI18N
        f_TriMod_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_triangularTECLayout = new javax.swing.GroupLayout(jP_triangularTEC);
        jP_triangularTEC.setLayout(jP_triangularTECLayout);
        jP_triangularTECLayout.setHorizontalGroup(
            jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_triangularTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jP_triangularTECLayout.createSequentialGroup()
                        .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(27, 27, 27)
                        .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(f_TriMax_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_TriMin_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f_TriMod_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel24))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jP_triangularTECLayout.setVerticalGroup(
            jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_triangularTECLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(f_TriMin_TEC, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(f_TriMax_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jP_triangularTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(f_TriMod_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        jP_deterministicoTEC.setMaximumSize(new java.awt.Dimension(216, 166));
        jP_deterministicoTEC.setMinimumSize(new java.awt.Dimension(216, 166));

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel25.setText("Valor:");

        f_DetVal_TEC.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        f_DetVal_TEC.setMinimumSize(new java.awt.Dimension(100, 20));
        f_DetVal_TEC.setName(""); // NOI18N
        f_DetVal_TEC.setPreferredSize(new java.awt.Dimension(100, 20));

        javax.swing.GroupLayout jP_deterministicoTECLayout = new javax.swing.GroupLayout(jP_deterministicoTEC);
        jP_deterministicoTEC.setLayout(jP_deterministicoTECLayout);
        jP_deterministicoTECLayout.setHorizontalGroup(
            jP_deterministicoTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_deterministicoTECLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addGap(18, 18, 18)
                .addComponent(f_DetVal_TEC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jP_deterministicoTECLayout.setVerticalGroup(
            jP_deterministicoTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jP_deterministicoTECLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jP_deterministicoTECLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(f_DetVal_TEC, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        setLocation(new java.awt.Point(250, 250));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(539, 401));
        setResizable(false);
        setSize(new java.awt.Dimension(539, 401));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel2.setMaximumSize(new java.awt.Dimension(480, 40));
        jPanel2.setMinimumSize(new java.awt.Dimension(480, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(480, 40));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Tempo Maximo: ");
        jPanel2.add(jLabel1);

        tf_TempoMaximo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tf_TempoMaximo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_TempoMaximo.setMaximumSize(new java.awt.Dimension(100, 30));
        tf_TempoMaximo.setMinimumSize(new java.awt.Dimension(100, 30));
        tf_TempoMaximo.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel2.add(tf_TempoMaximo);

        getContentPane().add(jPanel2);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(450, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(450, 40));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 40));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("TEC");
        jLabel2.setMaximumSize(new java.awt.Dimension(40, 30));
        jLabel2.setMinimumSize(new java.awt.Dimension(40, 30));
        jLabel2.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel1.add(jLabel2);

        cb_TEC.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_TEC.setMaximumSize(new java.awt.Dimension(250, 40));
        cb_TEC.setMinimumSize(new java.awt.Dimension(250, 40));
        cb_TEC.setPreferredSize(new java.awt.Dimension(250, 40));
        cb_TEC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_TECActionPerformed(evt);
            }
        });
        jPanel1.add(cb_TEC);
        jPanel1.add(filler4);

        getContentPane().add(jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("");

        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setMaximumSize(new java.awt.Dimension(450, 40));
        jPanel4.setMinimumSize(new java.awt.Dimension(450, 40));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 40));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("TS");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 30));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 30));
        jLabel3.setPreferredSize(new java.awt.Dimension(40, 30));
        jPanel4.add(jLabel3);

        cb_TS.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cb_TS.setMaximumSize(new java.awt.Dimension(250, 40));
        cb_TS.setMinimumSize(new java.awt.Dimension(250, 40));
        cb_TS.setPreferredSize(new java.awt.Dimension(250, 40));
        jPanel4.add(cb_TS);
        jPanel4.add(filler6);

        getContentPane().add(jPanel4);

        panel_Parametros.setMaximumSize(new java.awt.Dimension(510, 250));
        panel_Parametros.setMinimumSize(new java.awt.Dimension(510, 250));
        panel_Parametros.setPreferredSize(new java.awt.Dimension(510, 250));
        panel_Parametros.setLayout(new javax.swing.BoxLayout(panel_Parametros, javax.swing.BoxLayout.LINE_AXIS));

        panel_ParametroTEC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_ParametroTEC.setMaximumSize(new java.awt.Dimension(250, 220));
        panel_ParametroTEC.setMinimumSize(new java.awt.Dimension(250, 220));
        panel_ParametroTEC.setPreferredSize(new java.awt.Dimension(250, 220));
        panel_ParametroTEC.setLayout(new javax.swing.BoxLayout(panel_ParametroTEC, javax.swing.BoxLayout.PAGE_AXIS));

        panel_TituloParametroTEC.setMaximumSize(new java.awt.Dimension(250, 40));
        panel_TituloParametroTEC.setMinimumSize(new java.awt.Dimension(250, 40));
        panel_TituloParametroTEC.setPreferredSize(new java.awt.Dimension(250, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Parametros TEC");
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel4.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 25));
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panel_TituloParametroTEC.add(jLabel4);

        panel_ParametroTEC.add(panel_TituloParametroTEC);

        panel_Parametros.add(panel_ParametroTEC);
        panel_Parametros.add(filler2);

        panel_ParametroTS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel_ParametroTS.setMaximumSize(new java.awt.Dimension(250, 220));
        panel_ParametroTS.setMinimumSize(new java.awt.Dimension(250, 220));
        panel_ParametroTS.setPreferredSize(new java.awt.Dimension(250, 220));
        panel_ParametroTS.setLayout(new javax.swing.BoxLayout(panel_ParametroTS, javax.swing.BoxLayout.PAGE_AXIS));

        panel_TituloParametroTS.setMaximumSize(new java.awt.Dimension(250, 40));
        panel_TituloParametroTS.setMinimumSize(new java.awt.Dimension(250, 40));
        panel_TituloParametroTS.setPreferredSize(new java.awt.Dimension(250, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Parametros TS");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 25));
        jLabel7.setMinimumSize(new java.awt.Dimension(150, 25));
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 25));
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panel_TituloParametroTS.add(jLabel7);

        panel_ParametroTS.add(panel_TituloParametroTS);

        panel_Parametros.add(panel_ParametroTS);

        getContentPane().add(panel_Parametros);

        jPanel5.setMaximumSize(new java.awt.Dimension(480, 45));
        jPanel5.setMinimumSize(new java.awt.Dimension(480, 45));
        jPanel5.setPreferredSize(new java.awt.Dimension(480, 45));

        b_Simular.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        b_Simular.setText("Simular");
        b_Simular.setMaximumSize(new java.awt.Dimension(100, 40));
        b_Simular.setMinimumSize(new java.awt.Dimension(100, 40));
        b_Simular.setPreferredSize(new java.awt.Dimension(100, 40));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(b_Simular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(b_Simular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_TECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_TECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_TECActionPerformed

    private void f_NorMed_TSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_NorMed_TSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_NorMed_TSActionPerformed

    private void f_NorMed_TECActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f_NorMed_TECActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_f_NorMed_TECActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Simular;
    private javax.swing.JComboBox cb_TEC;
    private javax.swing.JComboBox cb_TS;
    private javax.swing.JCheckBox chb_ExpOff_TEC;
    private javax.swing.JCheckBox chb_ExpOff_TS;
    private javax.swing.JTextField f_DetVal_TEC;
    private javax.swing.JTextField f_DetVal_TS;
    private javax.swing.JTextField f_ExpMed_TEC;
    private javax.swing.JTextField f_ExpMed_TS;
    private javax.swing.JTextField f_ExpOff_TEC;
    private javax.swing.JTextField f_ExpOff_TS;
    private javax.swing.JTextField f_NorDes_TEC;
    private javax.swing.JTextField f_NorDes_TS;
    private javax.swing.JTextField f_NorMed_TEC;
    private javax.swing.JTextField f_NorMed_TS;
    private javax.swing.JTextField f_TriMax_TEC;
    private javax.swing.JTextField f_TriMax_TS;
    private javax.swing.JTextField f_TriMin_TEC;
    private javax.swing.JTextField f_TriMin_TS;
    private javax.swing.JTextField f_TriMod_TEC;
    private javax.swing.JTextField f_TriMod_TS;
    private javax.swing.JTextField f_UniMax_TEC;
    private javax.swing.JTextField f_UniMax_TS;
    private javax.swing.JTextField f_UniMin_TEC;
    private javax.swing.JTextField f_UniMin_TS;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_deterministicoTEC;
    private javax.swing.JPanel jP_deterministicoTS;
    private javax.swing.JPanel jP_exponencialTEC;
    private javax.swing.JPanel jP_exponencialTS;
    private javax.swing.JPanel jP_normalTEC;
    private javax.swing.JPanel jP_normalTS;
    private javax.swing.JPanel jP_triangularTEC;
    private javax.swing.JPanel jP_triangularTS;
    private javax.swing.JPanel jP_uniformeTEC;
    private javax.swing.JPanel jP_uniformeTS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panel_ParametroTEC;
    private javax.swing.JPanel panel_ParametroTS;
    private javax.swing.JPanel panel_Parametros;
    private javax.swing.JPanel panel_TituloParametroTEC;
    private javax.swing.JPanel panel_TituloParametroTS;
    private javax.swing.JTextField tf_TempoMaximo;
    // End of variables declaration//GEN-END:variables

    
}
