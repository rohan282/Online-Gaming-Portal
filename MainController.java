
package com.example.crewmgmt;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.lang.reflect.Member;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * author Rohan
 */


public class MainController {



    @FXML
    TextField pid=new TextField();
    @FXML
    TextField fname=new TextField();
    @FXML
    TextField lname=new TextField();
    @FXML
    TextField ad=new TextField();
    @FXML
    TextField postalcode=new TextField();
    @FXML
    TextField province=new TextField();
    @FXML
    TextField phno=new TextField();


    //---------------------------------

    @FXML
    TextField id2=new TextField();
    @FXML
    TextField fname2=new TextField();
    @FXML
    TextField lname2=new TextField();
    @FXML
    TextField add2=new TextField();
    @FXML
    TextField postal2=new TextField();
    @FXML
    TextField prov2=new TextField();
    @FXML
    TextField ph2=new TextField();




    //-------------------------

    @FXML
    TextField gid=new TextField();
    @FXML
    TextField gname=new TextField();

    @FXML
    TextField pgid=new TextField();
    @FXML
    TextField ggid=new TextField();
    @FXML
    TextField ppid=new TextField();
    @FXML
    DatePicker pdate=new DatePicker();
    @FXML
    TextField score=new TextField();



    @FXML
    Label error=new Label();

    @FXML
    Button add=new Button();
    @FXML
    Button add_game=new Button();
    @FXML
    Button pg_add=new Button();
    @FXML
    Button save=new Button();


    Alert alert = new Alert(Alert.AlertType.INFORMATION);//message box

    @FXML
    TableView tv=new TableView();
    @FXML
   ComboBox combo=new ComboBox();
    @FXML
    ComboBox combo2=new ComboBox();

    @FXML
     private TableColumn<member,Integer> player_id;

    @FXML
    private TableColumn<member,String> first_name;

    @FXML
    private TableColumn<member,String> last_name;

    @FXML
    private TableColumn<member,String> game_title;


    Connection con;

    @FXML
    private void initialize() throws SQLException {


        player_id.setCellValueFactory(new PropertyValueFactory<member,Integer>("player_id"));


        first_name.setCellValueFactory(new PropertyValueFactory<member,String>("first_name"));


        last_name.setCellValueFactory(new PropertyValueFactory<member,String>("last_name"));


        game_title.setCellValueFactory(new PropertyValueFactory<member,String>("game_title"));




         con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");



        String sql="select * from player";

        Statement stmt=con.createStatement();

        // execute query

        ResultSet rs=stmt.executeQuery(sql);

        while(rs.next())
        {
            combo.getItems().add(rs.getInt(1));
            combo2.getItems().add(rs.getInt(1));
        }

        //close the connection object
        con.close();



}



    public void add_click(ActionEvent ae) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");



        String sql="insert into player values(?,?,?,?,?,?,?)";

        // create the statement object
        PreparedStatement ps=con.prepareStatement(sql);

        int id= Integer.parseInt(pid.getText());
        String firstname=fname.getText();
        String lastname=lname.getText();
        String address=ad.getText();
        String pcode=postalcode.getText();
        String prov=province.getText();
        String phone=phno.getText();



        ps.setInt(1, id);
        ps.setString(2, firstname);
        ps.setString(3, lastname);
        ps.setString(4, address);
        ps.setString(5, pcode);
        ps.setString(6, prov);
        ps.setString(7, phone);

        int n=ps.executeUpdate();

        if(n>0) {
            alert.setTitle("success");
            alert.setHeaderText("success");
            alert.setContentText("Record inserted");
            alert.show();



            pid.setText("");
            fname.setText("");
            lname.setText("");
            ad.setText("");
            province.setText("");
            phno.setText("");
            postalcode.setText("");


            //------------------------------------------

            // con= DriverManager.getConnection(
                  //  "jdbc:oracle:thin:@localhost:1521:xe","system","admin");



             sql="select * from player";

            Statement stmt=con.createStatement();

            //execute query

            ResultSet rs=stmt.executeQuery(sql);
            combo.getItems().clear();
            combo2.getItems().clear();

            while(rs.next())
            {
                combo.getItems().add(rs.getInt(1));
                combo2.getItems().add(rs.getInt(1));
            }

            //close the connection object
            con.close();




        }





    }


//game tab  add record

    public void add_game_click(ActionEvent ae) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");



        String sql="insert into game values(?,?)";

        // create the statement object
        PreparedStatement ps=con.prepareStatement(sql);

        int id= Integer.parseInt(gid.getText());
        String name=gname.getText();




        ps.setInt(1, id);
        ps.setString(2, name);


        int n=ps.executeUpdate();

        if(n>0) {
            alert.setTitle("success");
            alert.setHeaderText("success");
            alert.setContentText("Record inserted");
            alert.show();



            gid.setText("");
            gname.setText("");



        }


       con.close();


    }




    //player and game add button


    public void add_pg_click(ActionEvent ae) throws SQLException, ParseException {

        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");




                String sql="insert into playerandgame values(?,?,?,?,?)";

        // create the statement object
        PreparedStatement ps=con.prepareStatement(sql);

        int id= Integer.parseInt(pgid.getText());
        int game_id1=Integer.parseInt(ggid.getText());
        int player_id1=Integer.parseInt(ppid.getText());
        int score1=Integer.parseInt(score.getText());
        java.util.Date dt=null;

        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
         dt= sdf.parse(pdate.getValue().toString());

        long l=dt.getTime();
        Date sdt=new Date(l);


        ps.setInt(1, id);
        ps.setInt(2, game_id1);
        ps.setInt(3, player_id1);
        ps.setDate(4,sdt);
        ps.setInt(5,score1);

        int n=ps.executeUpdate();

        if(n>0) {
            alert.setTitle("success");
            alert.setHeaderText("success");
            alert.setContentText("Record inserted");
            alert.show();



            gid.setText("");
            gname.setText("");



        }

     con.close();



    }


    public void combo_click(ActionEvent ae) throws SQLException {

        //Connection con = DriverManager.getConnection(
            //    "jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");

        int id;
        String fname,lname,game;

           id= (int) combo.getSelectionModel().getSelectedItem();
        String sql=String.format("select p.player_id,p.first_name,p.last_name,g.game_title from player p, game g, playerandgame pag where p.player_id=pag.player_id and  g.game_id=pag.game_id and p.player_id=%d",id);

        Statement st=con.createStatement();




        //execute query

        ResultSet rs=st.executeQuery(sql);



        ObservableList<member> ol = FXCollections.observableArrayList();


        while(rs.next())  //Add Data to TableView
        {
            id=rs.getInt(1);
            fname=rs.getString(2);
            lname=rs.getString(3);
            game=rs.getString(4);

            member m=new member(id,fname,lname,game);


           ol.add(m);


        };

        tv.setItems(ol);
        //close the connection object
       con.close();

    }

    //----------------------
    //combo box for selecting player ID to edit record
    public void combo2_click(ActionEvent ae) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");

        int id;
        String fname,lname,game;

        id= (int) combo2.getSelectionModel().getSelectedItem();

        String sql=String.format("select * from player where player_id=%d",id);

        // create the statement object
          Statement st=con.createStatement();



        //execute query
        ResultSet rs=st.executeQuery(sql);



        while(rs.next())  //display Data to text boxes
        {

            fname2.setText(rs.getString(2));
            lname2.setText(rs.getString(3));
            add2.setText(rs.getString(4));
            postal2.setText(rs.getString(5));
            prov2.setText(rs.getString(6));
            ph2.setText(rs.getString(7));



        }
        con.close();


    }

//------------------------------
    //save button for update record

    public void save_click(ActionEvent ae) throws SQLException {

        Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ambulance?autoReconnect=true&useSSL=false","root","root1313");

        int id;


        String firstname=fname2.getText();
        String lastname=lname2.getText();
        String address=add2.getText();
        String pcode=postal2.getText();
        String prov=prov2.getText();
        String phone=ph2.getText();

        id= (int) combo2.getSelectionModel().getSelectedItem();
        String sql=String.format("update player set first_name='%s',last_name='%s' ,  address='%s', postal_code='%s' ,province='%s',  phone_number='%s'  where player_id=%d",firstname,lastname,address,pcode,prov,phone,id);

        Statement st=con.createStatement();
        int n=st.executeUpdate(sql);


        if(n>0) {
            alert.setTitle("success");
            alert.setHeaderText("success");
            alert.setContentText("Record updated");
            alert.show();



            fname2.setText("");
            lname2.setText("");
            add2.setText("");
            prov2.setText("");
            ph2.setText("");
            postal2.setText("");


        }

    }



}

