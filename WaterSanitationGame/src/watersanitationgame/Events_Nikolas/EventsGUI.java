package watersanitationgame.Events_Nikolas;

/**
 *
 * @author NIKOLAS MISINS
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import watersanitationgame.Save;


public class EventsGUI extends javax.swing.JFrame {
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EventsGUI.class.getName());
    //variables
    private ArrayList<EventOb> Elist; //
    private ArrayList<Save> slist;
    private int count, saveIndex;
    private boolean loaded; //tracks whether event data(text) has been loaded in
    
    public EventsGUI(int saveIndex) {
        initComponents();
        count=0;
        Elist = new ArrayList<>();
        loaded=false;
        PositiveBTN.setVisible(false);
        NegativeBTN.setVisible(false);
        slist = new ArrayList<>();
        this.saveIndex = saveIndex;
        posScrollPane.setVisible(false);
        negScrollPane.setVisible(false);
    }

    private EventsGUI() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    //one time function that only runs to load in data regarding each event
    private void loadEventData(){
        File f;
        FileReader fr;
        BufferedReader br;
        String textData,posBtnText,negBtnText;
        try{
            f = new File("eventDetails.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            textData = br.readLine();
            while(textData != null){
                if (textData.equalsIgnoreCase("input")){
                    //in the eventDetails.txt, data follows this format, line by line: isInputEvent->EventText->positiveButtonText->NegativeButtonText
                    textData = br.readLine();
                    posBtnText = br.readLine();
                    negBtnText = br.readLine();
                    EventOb e = new EventOb(true, textData,count,posBtnText,negBtnText);
                    Elist.add(e);
                }else{
                    textData = br.readLine();
                    EventOb e = new EventOb(false, textData,count);
                    Elist.add(e);
                }
                count+=1;
                textData = br.readLine();
            }
            br.close(); 
            count=0;
        }catch(IOException e){
            System.out.println("Error code: " + e);
        }
        loaded=true;
    }
    
    //loads saved data file, is called multiple times throughout program
    private void loadSaveFile(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Saves.dat"))){
            slist = (ArrayList<Save>)ois.readObject();
        }catch(FileNotFoundException ex){
            System.out.println("error, no save file exists. error: " + ex);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("error class not found: " + ex);
        }  
    }
    
    private void loadEvent(){
        if ((count<Elist.size())){ //bottom check runs only if there are more events to go through, otherwise it opens a new Jframe form
            if(Elist.get(count).isIsInputEvent()){ //if InputEvent, show choice buttons
                
                ProceedBTN.setVisible(false);
                PositiveBTN.setVisible(true);
                NegativeBTN.setVisible(true);
                posScrollPane.setVisible(true);
                negScrollPane.setVisible(true);
                
                //PositiveBTN.setText(Elist.get(count).getBtnPos());
                //NegativeBTN.setText(Elist.get(count).getBtnNeg());
                posTA.setText(Elist.get(count).getBtnPos());
                negTA.setText(Elist.get(count).getBtnNeg());
            }else{ //show proceed button
                ProceedBTN.setVisible(true);
                PositiveBTN.setVisible(false);
                NegativeBTN.setVisible(false);
                posScrollPane.setVisible(false);
                negScrollPane.setVisible(false);
            }
            //load eventText
            EventTextTA.setText(Elist.get(count).printEventDetails());
        }else{
            //open new Jframe form
            LastEventGUI leg = new LastEventGUI(saveIndex);
            leg.setVisible(true);
            dispose();
        }
        count+=1;
    }
    
    //these 2 functions increase or decrease player score depending on what kind of choice the made
    private void updatePos(){
        loadSaveFile();
        slist.get(saveIndex).setGameScore( slist.get(saveIndex).getGameScore() + 10 );
        updateDecisions(true);
        saveToFile();
    }
    
    private void updateNeg(){
        loadSaveFile();
        slist.get(saveIndex).setGameScore( slist.get(saveIndex).getGameScore() - 10 );
        updateDecisions(false);
        saveToFile();
    }
    
    //updates the save file with SPECIFIC infortmation about what the user chose to do
    private void updateDecisions(boolean choice){
        switch(count){ //switch case 0 is the default event you start with, and 1 is the first event in the .txt
            case 2:
                slist.get(saveIndex).setBeganSafetyInspections(choice);
                break;
            case 3:
                slist.get(saveIndex).setInterviewAnswer(choice);
                break;
            case 5:
                slist.get(saveIndex).setRedirectedWater(choice);
                break;
            case 10:
                slist.get(saveIndex).setTookBribe(choice);
                break;
            case 12:
                slist.get(saveIndex).setStayedInOffice(choice);
                break;
        }
    }
    
    //save slist to file Saves.dat
    private void saveToFile(){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Saves.dat"))){
            oos.writeObject(slist);
        } catch (FileNotFoundException ex) {
            System.getLogger(EventsGUI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(EventsGUI.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EventTextTA = new javax.swing.JTextArea();
        ProceedBTN = new javax.swing.JButton();
        PositiveBTN = new javax.swing.JButton();
        NegativeBTN = new javax.swing.JButton();
        posScrollPane = new javax.swing.JScrollPane();
        posTA = new javax.swing.JTextArea();
        negScrollPane = new javax.swing.JScrollPane();
        negTA = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        EventTextTA.setEditable(false);
        EventTextTA.setColumns(20);
        EventTextTA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        EventTextTA.setLineWrap(true);
        EventTextTA.setRows(5);
        EventTextTA.setText("You settle into your new position as the water sanitation manger...");
        EventTextTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(EventTextTA);

        ProceedBTN.setBackground(new java.awt.Color(204, 204, 204));
        ProceedBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProceedBTN.setText("PROCEED");
        ProceedBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ProceedBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProceedBTNActionPerformed(evt);
            }
        });

        PositiveBTN.setBackground(new java.awt.Color(204, 204, 204));
        PositiveBTN.setText("Option 1");
        PositiveBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PositiveBTN.setMaximumSize(new java.awt.Dimension(50, 20));
        PositiveBTN.setMinimumSize(new java.awt.Dimension(50, 20));
        PositiveBTN.setPreferredSize(new java.awt.Dimension(50, 20));
        PositiveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositiveBTNActionPerformed(evt);
            }
        });

        NegativeBTN.setBackground(new java.awt.Color(204, 204, 204));
        NegativeBTN.setText("Option 2");
        NegativeBTN.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        NegativeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegativeBTNActionPerformed(evt);
            }
        });

        posTA.setEditable(false);
        posTA.setColumns(20);
        posTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        posTA.setLineWrap(true);
        posTA.setRows(5);
        posTA.setWrapStyleWord(true);
        posScrollPane.setViewportView(posTA);

        negTA.setEditable(false);
        negTA.setColumns(20);
        negTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        negTA.setLineWrap(true);
        negTA.setRows(5);
        negTA.setWrapStyleWord(true);
        negScrollPane.setViewportView(negTA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(posScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                                .addComponent(negScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(PositiveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NegativeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ProceedBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(304, 304, 304))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ProceedBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(negScrollPane)
                    .addComponent(posScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PositiveBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NegativeBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ProceedBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProceedBTNActionPerformed
        // If event data(text and input type) not loaded, load it in from the txt file
        if (!loaded){
            loadEventData();
        }
        loadEvent();
    }//GEN-LAST:event_ProceedBTNActionPerformed

    private void PositiveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PositiveBTNActionPerformed
        updatePos(); //updates user score positively
        loadEvent();
    }//GEN-LAST:event_PositiveBTNActionPerformed

    private void NegativeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegativeBTNActionPerformed
        updateNeg(); //updates user score negatively
        loadEvent();
    }//GEN-LAST:event_NegativeBTNActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new EventsGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea EventTextTA;
    private javax.swing.JButton NegativeBTN;
    private javax.swing.JButton PositiveBTN;
    private javax.swing.JButton ProceedBTN;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane negScrollPane;
    private javax.swing.JTextArea negTA;
    private javax.swing.JScrollPane posScrollPane;
    private javax.swing.JTextArea posTA;
    // End of variables declaration//GEN-END:variables
}
