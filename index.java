import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class productos {

    private String code;
    private String name;
    private String amount;
    private String description;

    public productos() {
    }

    public productos(String code, String name, String amount,
            String description) {
        this.code = code;
        this.name = name;
        this.amount = amount;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String insert() {
        try {
            File fi = new File("java.txt");
            if (!fi.exists()) {
                fi.createNewFile();
            }
            FileReader fr = new FileReader(fi);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("code: " + code) && line.length()
                        == ("code: " + code).length()) {
                    br.close();
                    return "El código ya ha sido introducido\n"
                            + "anteriormente";
                }
            }

            FileWriter fw = new FileWriter(fi, true);
            fw.write("code: " + code + "\n" + "name: " + name + "\n"
                    + "amount: " + amount + "\n"
                    + "description: " + description + "\n");
            fw.close();
            fr.close();
        } catch (IOException ex) {
            return "Error";
        }
        return "Datos introducidos correctamente";
    }

    public String list() {
        String text = "";
        String line;

        try {
            File fi = new File("java.txt");
            FileReader fr = new FileReader(fi);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();

            while (line != null) {
                text = text + line + "\n";
                line = br.readLine();

            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }

    public String search() {
        String code = JOptionPane.showInputDialog("Introduzca "
                + "código");
        String line;
        String text = "";
        boolean bln = false;

        try {
            File fi = new File("java.txt");
            FileReader fr = new FileReader(fi);
            BufferedReader br = new BufferedReader(fr);
            line = br.readLine();

            while (line != null) {
                if (line.startsWith("code: " + code)) {
                    for (int i = 0; i < 4; i++) {
                        line = line.substring(line.indexOf(" ") + 1);
                        text = text + line + "\n";
                        line = br.readLine();
                        bln = true;
                    }
                    break;
                } else {
                    line = br.readLine();
                }
            }
            br.close();
            fr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        if (bln) {
            return text;
        } else {
            return "Error";
        }
    }

}

public class formulario extends javax.swing.JFrame {

    public formulario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {

        btninsert = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        lblcode = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblamount = new javax.swing.JLabel();
        lbldescription = new javax.swing.JLabel();
        txtcode = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        txtamount = new javax.swing.JTextField();
        txtdescription = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtlist = new javax.swing.JTextArea();
        btnshow = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        lblproductslist = new javax.swing.JLabel();
        btndelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario de Gestión");

        btninsert.setText("Insertar");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });

        btnsearch.setText("Buscar");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        lblcode.setText("Código");

        lblname.setText("Nombre");

        lblamount.setText("Cantidad");

        lbldescription.setText("Descripción");

        txtcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodeActionPerformed(evt);
            }
        });

        txtlist.setColumns(20);
        txtlist.setRows(5);
        jScrollPane1.setViewportView(txtlist);

        btnshow.setText("Mostrar");
        btnshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnshowActionPerformed(evt);
            }
        });

        btnexit.setText("Salir");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        lblproductslist.setText("Listado de productos");

        btndelete.setText("Borrar");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndelete)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btninsert)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbldescription, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnsearch))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblcode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnshow)
                                .addGap(18, 18, 18)
                                .addComponent(btnexit))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblproductslist, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblproductslist, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblamount, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbldescription, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btninsert)
                    .addComponent(btnsearch)
                    .addComponent(btnshow)
                    .addComponent(btnexit))
                .addGap(18, 18, 18)
                .addComponent(btndelete)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodeActionPerformed

    }//GEN-LAST:event_txtcodeActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        productos bi = new productos(txtcode.getText(),
                txtname.getText(), txtamount.getText(),
                txtdescription.getText());
        String i = bi.insert();
        txtlist.setText(i);
        txtcode.setText("");
        txtname.setText("");
        txtamount.setText("");
        txtdescription.setText("");
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnshowActionPerformed
        productos bshow = new productos();
        txtlist.setText(bshow.list());
        txtcode.setText("");
        txtname.setText("");
        txtamount.setText("");
        txtdescription.setText("");
    }//GEN-LAST:event_btnshowActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        productos bsearch = new productos();
        String text = bsearch.search();
        String[] lines = text.split("\n");

        if (lines[0].equals("Error")) {
            txtcode.setText("Código incorrecto");
            txtname.setText("");
            txtamount.setText("");
            txtdescription.setText("");
            txtlist.setText("Código introducido incorrectamente.\n"
                    + "Vuelva a intentarlo");
        } else {

            txtcode.setText(lines[0]);
            txtname.setText(lines[1]);
            txtamount.setText(lines[2]);
            txtdescription.setText(lines[3]);
            txtlist.setText("Código introducido correctamente");

        }

    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        txtlist.setText("");
        txtcode.setText("");
        txtname.setText("");
        txtamount.setText("");
        txtdescription.setText("");
    }//GEN-LAST:event_btndeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnshow;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblamount;
    private javax.swing.JLabel lblcode;
    private javax.swing.JLabel lbldescription;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblproductslist;
    private javax.swing.JTextField txtamount;
    private javax.swing.JTextField txtcode;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextArea txtlist;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables

}