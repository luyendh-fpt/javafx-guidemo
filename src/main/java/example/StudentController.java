package example;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import guidemo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private JFXTextField txtAvatar;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtRollnumber;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, ImageView> columnAvatar;

    @FXML
    private TableColumn<Student, String> columnRollnumber;

    @FXML
    private TableColumn<Student, String> columnName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.tableView.setRowFactory(new Callback<TableView<Student>, TableRow<Student>>() {
            @Override
            public TableRow<Student> call(TableView<Student> param) {
                TableRow<Student> studentTableRow = new TableRow<>();
                studentTableRow.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!studentTableRow.isEmpty()) {
                            Student student = studentTableRow.getItem();
                            txtRollnumber.setText(student.getRollNumber());
                            txtName.setText(student.getName());
                            txtAvatar.setText(student.getAvatar());
                        }
                    }
                });
                return studentTableRow;
            }
        });

        this.columnAvatar.setCellValueFactory(new PropertyValueFactory<>("imageAvatar"));
        this.columnRollnumber.setCellValueFactory(new PropertyValueFactory<>("rollNumber"));
        this.columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tableView.setItems(loadStudents());
    }

    private ObservableList<Student> loadStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();
        students.add(new Student("A001", "Hung", "https://pub-static.haozhaopian.net/static/web/site/features/one-tap-enhance/images/1-tap-enhance_comparison_chart0cd39fa2358c48f674db97b65327666e.jpg"));
        students.add(new Student("A002", "Tung", "https://1.bp.blogspot.com/-O7MaSw-LHhI/XKJD_ppGDxI/AAAAAAAAB30/eKEHsL6X5ckqv_EwaQn2Py_MwMiZ2n0aQCLcBGAs/s1600/41283661_1953293778082803_7163914525270343680_n.jpg"));
        students.add(new Student("A003", "Hot Girl", "https://static.tamil.news18.com/tamil/uploads/2019/04/1-22.jpg"));
        return students;
    }

    @FXML
    void saveStudent(ActionEvent event) {
        Student student = new Student(txtRollnumber.getText(), txtName.getText(), txtAvatar.getText());
        for (int i = 0; i < this.tableView.getItems().size(); i++) {
            Student st = this.tableView.getItems().get(i);
            if(st.getRollNumber().equals(student.getRollNumber())){
                this.tableView.getItems().remove(i);
            }
        }
        tableView.getItems().add(student);
    }

    @FXML
    void doDelete(ActionEvent event) {
        Student student = this.tableView.getSelectionModel().getSelectedItem();
        this.tableView.getItems().remove(student);
    }
}
