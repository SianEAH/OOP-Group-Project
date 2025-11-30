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
    ArrayList<EventOb> Elist; //
    ArrayList<Save> slist;
    private int count, saveIndex;
    private boolean loaded; //tracks whether event data(text) has been loaded in
    
    public EventsGUI() {
        initComponents();
        count=0;
        Elist = new ArrayList<>();
        loaded=false;
        PositiveBTN.setVisible(false);
        NegativeBTN.setVisible(false);
        slist = new ArrayList<>();
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
                PositiveBTN.setText(Elist.get(count).getBtnPos());
                NegativeBTN.setText(Elist.get(count).getBtnNeg());
            }else{ //show proceed button
                ProceedBTN.setVisible(true);
                PositiveBTN.setVisible(false);
                NegativeBTN.setVisible(false);
            }
            //load eventText
            EventTextTA.setText(Elist.get(count).printEventDetails());
        }else{
            //open new Jframe form
            LastEventGUI leg = new LastEventGUI();
            leg.setVisible(true);
            dispose();
        }
        count+=1;
    }
    
    //these 2 functions increase or decrease player score depending on what kind of choice the made
    private void updatePos(){
        loadSaveFile();
        slist.get(saveIndex).setGameScore( slist.get(saveIndex).getGameScore() - 10 );
        saveToFile();
    }
    
    private void updateNeg(){
        loadSaveFile();
        slist.get(saveIndex).setGameScore( slist.get(saveIndex).getGameScore() - 10 );
        saveToFile();
    }
    
    //save slist to file
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

        jScrollPane1 = new javax.swing.JScrollPane();
        EventTextTA = new javax.swing.JTextArea();
        ProceedBTN = new javax.swing.JButton();
        PositiveBTN = new javax.swing.JButton();
        NegativeBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        EventTextTA.setEditable(false);
        EventTextTA.setColumns(20);
        EventTextTA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        EventTextTA.setLineWrap(true);
        EventTextTA.setRows(5);
        EventTextTA.setText("You settle into your new position as the water sanitation manger...");
        EventTextTA.setWrapStyleWord(true);
        jScrollPane1.setViewportView(EventTextTA);

        ProceedBTN.setText("PROCEED");
        ProceedBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProceedBTNActionPerformed(evt);
            }
        });

        PositiveBTN.setText("resolve the issue");
        PositiveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PositiveBTNActionPerformed(evt);
            }
        });

        NegativeBTN.setText("ignore it, there are more important things at hand");
        NegativeBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegativeBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(PositiveBTN))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(163, 163, 163)
                                .addComponent(ProceedBTN)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(NegativeBTN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProceedBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(PositiveBTN)
                .addGap(18, 18, 18)
                .addComponent(NegativeBTN)
                .addGap(20, 20, 20))
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
        updatePos();
        loadEvent();
    }//GEN-LAST:event_PositiveBTNActionPerformed

    private void NegativeBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegativeBTNActionPerformed
        updateNeg();
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
