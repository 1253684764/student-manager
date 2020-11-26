
package frame;


import entity.Admin;

import entity.Department;
import factory.ServiceFactory;
import utils.AliOSSUtil;
import vo.StudentVo;
import sun.swing.table.DefaultTableCellHeaderRenderer;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.font.FontRenderContext;
import java.io.File;
import java.net.URL;
import java.security.acl.Group;
import java.util.List;
/**
 * @ClassName mainFrame
 * @Description TODO
 * @Author UnKnW
 * @Date 2020/11/15 0:21
 **/
public class mainFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel bottomPanel;
    private JPanel centerPanel;
    private JButton departButton;
    private JButton classButton;
    private JButton stuButton;
    private JButton jcButton;
    private JPanel departPanel;
    private JPanel classPanel;
    private JPanel stuPanel;
    private JPanel jcPanel;
    private JLabel glyLabel;
    private JPanel toolBarPanel;
    private JButton newButton;
    private JButton resetButton;
    private JPanel cententPanel;
    private JPanel addDepPanel;
    private JButton choseButton;
    private JLabel LogoLabel;
    private JTextField addField;
    private JButton refreshField;
    private JButton accButton;
    private JPanel treePanel;
    private JSplitPane splitPanel;
    private JPanel toolPanel;
    private JPanel classContentPanel;
    private JComboBox depCombobox;
    private JTextField textField1;
    private JButton 新增班级Button;
    private JPanel stuToolPanel;
    private JComboBox chdepcomboBox;
    private JComboBox chclasscomboBox;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 新增学生Button;
    private JButton 批量导入Button;
    private JPanel tablePanel;
    private String uploadFileUrl;
    private File file;

    private final CardLayout c;
    private static String adminName;
    private static int id = 1;

    private void showDepartments() {
        glyLabel.setText("管理员: " + entity.AdminName.getAdminName());
        //移除原有数据
        cententPanel.removeAll();
        //从service层获取到所有院系列表
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数(每行放4个)
        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
        //创建一个网格布局，每行4列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row, 4, 15, 15);
        cententPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            //给每个院系对象创建一个面板
            JPanel deepPanel = new JPanel();
            deepPanel.setPreferredSize(new Dimension(355, 350));
            JPanel depPanel = new JPanel();
            //设置合适大小
            depPanel.setPreferredSize(new Dimension(300, 350));
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
            JLabel nameLabel = new JLabel(department.getDepartmentName());
            //将院系名称设置给面板标题
            //depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            //新建一个JLabel便签，用来放置院系Logo，并指定大小
            JLabel logoLabel = new JLabel("<html><img src = '" + department.getLogo() + "' height='250'/></html>");
            //占位空白符
            JLabel blackLabel = new JLabel();
            blackLabel.setPreferredSize(new Dimension(200, 30));
            //删除按钮
            JButton delButton = new JButton("删除");
            delButton.addActionListener(e -> {
                ServiceFactory.getDepartmentServiceInstance().deleteId(department.getId());
                this.showDepartments();
            });
            //将院系名称加入院系面板
            depPanel.add(nameLabel);
            //图标标签加入院系面板
            depPanel.add(logoLabel);
            //按钮加入院系面板
            depPanel.add(delButton);
            //院系面板加入主题内容面板
            deepPanel.add(depPanel);
            cententPanel.add(deepPanel);
            //刷新主题内容面板
            cententPanel.revalidate();
        }
    }

    public mainFrame() {
        init();
        c = new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1", departPanel);
        centerPanel.add("2", classPanel);
        centerPanel.add("3", stuPanel);
        centerPanel.add("4", jcPanel);
        departButton.addActionListener(e -> {
            c.show(centerPanel, "1");
            showDepartments();
        });
        classButton.addActionListener(e -> {
            c.show(centerPanel, "2");
            showClazz();
        });
        stuButton.addActionListener(e -> {
            c.show(centerPanel, "3");
            showStudents();
        });
        jcButton.addActionListener(e -> {
            c.show(centerPanel, "4");
        });
        showDepartments();
        newButton.addActionListener(e -> {
            boolean visible = addDepPanel.isVisible();
            if (!visible) {
                leftPanel.setPreferredSize(new Dimension(280, this.getHeight() - 100));
                addDepPanel.setVisible(true);
            } else {
                leftPanel.setPreferredSize(new Dimension(200, this.getHeight() - 100));
                addDepPanel.setVisible(false);
            }
        });
        refreshField.addActionListener(e -> {
            this.showDepartments();
        });
        addField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                addField.setText("");
            }
        });
        choseButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("C:/Users/UnKnW/Pictures/"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION) {
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                LogoLabel.setPreferredSize(new Dimension(250, 250));
                //图片强制缩放成和JLabel一样大小
                icon = new ImageIcon(icon.getImage().getScaledInstance(LogoLabel.getWidth(), LogoLabel.getHeight(), Image.SCALE_DEFAULT));
                LogoLabel.setIcon(icon);
            }
        });
        accButton.addActionListener(e -> {
            //上传文件到OSS并返回URL
            uploadFileUrl = AliOSSUtil.ossUpload(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(addField.getText().trim());
            department.setLogo(uploadFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n == 1) {
                JOptionPane.showMessageDialog(centerPanel, "新增院系成功啦");
                leftPanel.setPreferredSize(new Dimension(200, this.getHeight() - 100));
                addDepPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本框
                addField.setText("");
                LogoLabel.setIcon(null);
            } else {
                JOptionPane.showMessageDialog(centerPanel, "新增院系失败哦");
            }
        });
    }

    private void showClazz() {
        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        showCombobox(departmentList);
        showTree(departmentList);
        showClazz(departmentList);
    }

    private void showCombobox(List<Department> departments) {
        for (Department department : departments) {
            depCombobox.addItem(department);
        }
    }

    private void showTree(List<Department> departments) {
        treePanel.removeAll();
        //左侧树组件到根节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
        for (Department department : departments) {
            //院系名称作为一级叶子节点
            DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
            //加入根节点,构成一棵树
            root.add(group);
            List<entity.Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClassByDepId(department.getId());
            for (entity.Clazz clazz : clazzList) {
                //班级节点加入对应到院系节点
                DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
                group.add(node);
            }
        }
        //以root为根生成树
        final JTree tree = new JTree(root);
        tree.setRowHeight(30);
        tree.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        treePanel.add(tree, BorderLayout.CENTER);
        treePanel.revalidate();
    }

    private void showClazz(List<Department> departments) {
        classContentPanel.removeAll();
        classContentPanel.setLayout(new GridLayout(0, 5, 15, 15));
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 16);
        for (Department department : departments) {
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(120, 150));
            depPanel.setBackground(new Color(64, 98, 131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255, 255, 255));
            depPanel.add(depNameLabel, BorderLayout.NORTH);
            List<entity.Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClassByDepId(department.getId());
            DefaultListModel<entity.Clazz> listModel = new DefaultListModel<>();
            for (entity.Clazz clazz : clazzList) {
                listModel.addElement(clazz);
            }
            JList<entity.Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(101, 134, 184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane, BorderLayout.CENTER);
            classContentPanel.add(depPanel);
        }
    }

    private void showStudents() {
        component.CustomPanel stuInfoPanel = new component.CustomPanel("C:/Users/UnKnW/Pictures/bg.png");
        stuInfoPanel.setPreferredSize(new Dimension(300, 600));
        JLabel title = new JLabel("学生信息");
        title.setFont(new Font("楷体", Font.BOLD, 30));
        title.setForeground(new Color(97, 174, 239));
        stuInfoPanel.add(title);
        stuInfoPanel.repaint();
        stuPanel.add(stuInfoPanel, BorderLayout.EAST);

        List<StudentVo> students = ServiceFactory.getStudentServiceInstance().selectAll();
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"学号", "院系", "班级", "姓名", "性别", "地址", "手机号", "出生日期", "头像"});
        for (StudentVo student : students) {
            Object[] objects = new Object[]{
                    student.getId(), student.getDepartmentName(),
                    student.getClassName(), student.getStudentName(),
                    student.getGender(), student.getAddress(),
                    student.getPhone(), student.getBirthday(),
                    student.getAvatar()};
            model.addRow(objects);
        }
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMaxWidth(0);
        tc.setMinWidth(0);
        JTableHeader header = table.getTableHeader();
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(hr);
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
        header.setFont(new Font("楷体", Font.PLAIN, 18));
        table.setRowHeight(35);
        table.setBackground(new Color(223, 241, 234));
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            JOptionPane.showMessageDialog(null, table.getValueAt(row, 2).toString() +":"+
                    table.getValueAt(row, 3).toString());
        });


    }

    public void init() {
        this.setTitle("管理员主界面");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new mainFrame();
    }
}
