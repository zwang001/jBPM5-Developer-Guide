/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.salaboy.jbpm5.dev.guide;

import java.io.StringReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.drools.SystemEventListenerFactory;
import org.drools.persistence.jpa.JPAKnowledgeService;
import org.jbpm.task.*;
import org.jbpm.task.query.TaskSummary;
import org.jbpm.task.service.TaskService;
import org.jbpm.task.service.TaskServiceSession;
import org.jbpm.task.service.local.LocalTaskService;

/**
 *
 * @author salaboy
 */
public class TasksListUI extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private TaskService taskService;
    private TaskServiceSession taskSession;
    private Map<String, User> users = new HashMap<String, User>();
    private Map<String, Group> groups = new HashMap<String, Group>();
    private LocalTaskService localTaskService;
    private Map<String, Class> taskForms = new HashMap<String, Class>();

    /**
     * Creates new form TasksListUI
     */
    public TasksListUI() {
        initComponents();
        initTaskComponents();
        initTaskFormMappings();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tasklistsjTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        refreshjButton = new javax.swing.JButton();
        selectedUserjComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taskSummariesjTable = new javax.swing.JTable();
        perspectivejComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taskDefjTextPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        userjTextField = new javax.swing.JTextField();
        addUserjButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        groupjTextField = new javax.swing.JTextField();
        addGroupjButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        taskFormRegistryjTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tasks Console");

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        selectedUserjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "salaboy", "watman" }));
        selectedUserjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedUserjComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("User:");

        taskSummariesjTable.setModel(new javax.swing.table.DefaultTableModel(
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
        taskSummariesjTable.setShowGrid(true);
        taskSummariesjTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TasksListUI.this.mouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(taskSummariesjTable);

        perspectivejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "Detailed" }));

        jLabel3.setText("Perspective: ");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(refreshjButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(perspectivejComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(selectedUserjComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 108, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(selectedUserjComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(perspectivejComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(refreshjButton)
                .addContainerGap())
        );

        tasklistsjTabbedPane.addTab("Tasks List", jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Admin Parameters"));

        taskDefjTextPane.setText("(with (new Task()) \n{ priority = 55, \n  taskData = \n      (with( new TaskData()) { workItemId = 1 } ), \n                                           peopleAssignments = (with ( new PeopleAssignments() ) { potentialOwners = \t\t\t\t[users['salaboy']], recipients = [users['Administrator']] }),\n\t                   descriptions = [ new I18NText( 'en-UK', 'This is my description')], \n\t                   subjects = [ new I18NText( 'en-UK', 'This is my subject')], \n                                           names = [ new I18NText( 'en-UK', 'Correct Flow Average!!!')] })");
        jScrollPane1.setViewportView(taskDefjTextPane);

        jLabel2.setText("Mvel Task Definition:");

        jButton1.setText("Add Task");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Create Simple Task");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Users and Groups"));

        jLabel4.setText("User: ");

        addUserjButton.setText("Add User");
        addUserjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserjButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Group: ");

        addGroupjButton.setText("Add Group");
        addGroupjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addGroupjButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jLabel4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(userjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addUserjButton, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jLabel5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(groupjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(addGroupjButton)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(9, 9, 9)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(userjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(addUserjButton)
                    .add(jLabel5)
                    .add(groupjTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(addGroupjButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Task Forms Registry"));

        taskFormRegistryjTextArea.setColumns(20);
        taskFormRegistryjTextArea.setRows(5);
        jScrollPane4.setViewportView(taskFormRegistryjTextArea);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 13, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jLabel2)
                        .add(jPanel2Layout.createSequentialGroup()
                            .add(jButton1)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(jButton2))
                        .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 161, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton1)
                    .add(jButton2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(341, 341, 341))
        );

        tasklistsjTabbedPane.addTab("Admin", jPanel2);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tasklistsjTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tasklistsjTabbedPane, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 532, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        String selectedUser = (String) selectedUserjComboBox.getItemAt(selectedUserjComboBox.getSelectedIndex());
        System.out.println("Selected User: " + selectedUser);
        List<TaskSummary> tasks = localTaskService.getTasksAssignedAsPotentialOwner(selectedUser, "en-UK");
        System.out.println("Tasks: " + tasks + " - size: " + tasks.size());
        String selectedPerspective = (String) perspectivejComboBox.getItemAt(perspectivejComboBox.getSelectedIndex());
        if (selectedPerspective.equals("Simple")) {
            taskSummariesjTable.setModel(new SimpleTaskSummariesModel(tasks));
        } else {
            taskSummariesjTable.setModel(new DetailedTaskSummariesModel(tasks));
        }


    }//GEN-LAST:event_refreshjButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List<User> potentialOwners = new ArrayList<User>();
        potentialOwners.add(users.get("salaboy"));
        Task task = createSimpleTask(potentialOwners, users.get("administrator"));
        localTaskService.addTask(task, null);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selectTaskForm(JTable target, int row) {
        
        long taskId = ((TaskSummariesModel)target.getModel()).getTaskId(row);
        String taskName = ((TaskSummariesModel)target.getModel()).getTaskName(row);
        String selectedUser = (String) selectedUserjComboBox.getItemAt(selectedUserjComboBox.getSelectedIndex());
        System.out.println("Selected User: " + selectedUser);
        Class clazz = taskForms.get(taskName);
        Constructor constructor = null;
        try {
            constructor = clazz.getConstructor(LocalTaskService.class, long.class, String.class);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JPanel taskForm = null;
        try {
            taskForm = (JPanel) constructor.newInstance(localTaskService,taskId, selectedUser);
        } catch (InstantiationException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(TasksListUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //new MyTaskFormJPanel(localTaskService, taskId, selectedUser);
        tasklistsjTabbedPane.add(taskForm);
    }

    private void selectedUserjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedUserjComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectedUserjComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Map<String, Object> vars = new HashMap();
        vars.put("users", users);
        String taskDef = taskDefjTextPane.getText();
        Task task = (Task) TaskService.eval(new StringReader(taskDef), vars);
        localTaskService.addTask(task, null);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void addUserjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserjButtonActionPerformed
        // TODO add your handling code here:
        if (userjTextField.getText() != null && !userjTextField.getText().equals("")) {
            User user = new User(userjTextField.getText());
            taskSession.addUser(user);
            users.put(userjTextField.getText(), user);
        }

    }//GEN-LAST:event_addUserjButtonActionPerformed

    private void addGroupjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addGroupjButtonActionPerformed
        // TODO add your handling code here:
        if (groupjTextField.getText() != null && !groupjTextField.getText().equals("")) {
            Group group = new Group(groupjTextField.getText());
            taskSession.addGroup(group);
            groups.put(groupjTextField.getText(), group);
        }
    }//GEN-LAST:event_addGroupjButtonActionPerformed

    private void mouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            System.out.println("Double Clicked Row: "+row);
            selectTaskForm(target, row);
        }
    }//GEN-LAST:event_mouseClicked

    private Task createSimpleTask(List<User> users, User administrator) {
        Task task = new Task();
        task.setPriority(1);
        TaskData data = new TaskData();
        data.setWorkItemId(1);
        PeopleAssignments peopleAssignments = new PeopleAssignments();
        List<OrganizationalEntity> usersEntities = new ArrayList<OrganizationalEntity>();
        for (User user : users) {
            usersEntities.add(user);
        }
        List<OrganizationalEntity> adminsEntities = new ArrayList<OrganizationalEntity>();
        adminsEntities.add(administrator);
        peopleAssignments.setBusinessAdministrators(adminsEntities);
        peopleAssignments.setPotentialOwners(usersEntities);
        task.setPeopleAssignments(peopleAssignments);
        List<I18NText> names = new ArrayList<I18NText>();
        names.add(new I18NText("en-UK", "My Simple Task"));
        task.setNames(names);
        task.setDescriptions(names);
        task.setSubjects(names);
        data.setProcessInstanceId(1);
        data.setProcessSessionId(1);
        task.setTaskData(data);
        return task;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TasksListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TasksListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TasksListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TasksListUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TasksListUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addGroupjButton;
    private javax.swing.JButton addUserjButton;
    private javax.swing.JTextField groupjTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JComboBox perspectivejComboBox;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JComboBox selectedUserjComboBox;
    private javax.swing.JTextPane taskDefjTextPane;
    private javax.swing.JTextArea taskFormRegistryjTextArea;
    private javax.swing.JTable taskSummariesjTable;
    private javax.swing.JTabbedPane tasklistsjTabbedPane;
    private javax.swing.JTextField userjTextField;
    // End of variables declaration//GEN-END:variables

    private void initTaskComponents() {
        // Create an EntityManagerFactory based on the PU configuration
        emf = Persistence.createEntityManagerFactory("org.jbpm.task");
        // The Task Service will use the EMF to store our Task Status
        taskService = new TaskService(emf, SystemEventListenerFactory.getSystemEventListener());
        // We can uset the Task Service to get an instance of the Task Session which
        // allows us to introduce to our database the users and groups information before 
        // running our tests
        taskSession = taskService.createSession();
        // Adds 1 Administrator, 2 users and 1 Group
        addUsersAndGroups(taskSession);

        localTaskService = new LocalTaskService(taskService);
        //We need to set up an user to represent the user that is making the requests
        MockUserInfo userInfo = new MockUserInfo();
        taskService.setUserinfo(userInfo);
    }

    private void addUsersAndGroups(TaskServiceSession taskSession) {
        User user = new User("salaboy");
        User watman = new User("watman");
        taskSession.addUser(user);
        taskSession.addUser(watman);
        User administrator = new User("Administrator");
        taskSession.addUser(administrator);
        users.put("salaboy", user);
        users.put("watman", watman);
        users.put("administrator", administrator);
        Group myGroup = new Group("group1");
        taskSession.addGroup(myGroup);
        groups.put("group1", myGroup);

    }

    private void initTaskFormMappings() {
        taskForms.put("My Simple Task", MySimpleTaskFormJPanel.class);
        taskForms.put("Correct Flow Average!!!", OtherTaskForm.class);
        String mappings = "";
        for(String key : taskForms.keySet()){
            mappings += key + " -> " +taskForms.get(key) + "\n";
        }
        taskFormRegistryjTextArea.setText(mappings);
    }
}
