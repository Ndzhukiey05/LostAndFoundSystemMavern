
package lostandfoundsystem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import lostandfoundsystem.connection.DBConnection;
import lostandfoundsystem.domain.Item;
import lostandfoundsystem.domain.Report;
import lostandfoundsystem.domain.User;


public class LostItemDAO {
  
    private Connection connection;
    private PreparedStatement ps,repStatememt;
    
    
    public LostItemDAO(){
        try{
            connection = DBConnection.derbyConnection();
        }
        
        catch(SQLException er){
            System.out.println("ERROR: "+ er);
        }
    }
    
    
    public void submitReport(Item item, Report report, User currentUser){
        
        String insert_details = "insert into ITEM(ITEM_NAME, CATEGORY, DESCRIPTION, STATUS)"+
                "values(?,?,?,?)";
        
        String reportDetails = "insert into REPORTS(PERSON_ID, ITEM_ID, DATE_LOST,LOCATION, ITEM_IMAGE, ITEM_TYPE)"+
                "values(?,?,?,?,?,?)";
        
        int currentUserId = currentUser.getPersonId();
        report.setPersonID(currentUserId);
        
        try{
            
            ps = connection.prepareStatement(insert_details, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, item.getItemName());
            ps.setString(2, item.getCategory());
            ps.setString(3, item.getDescription());
            ps.setString(4, item.getStatus());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            int generatedKey =0;
            if(rs!= null){
                while(rs.next()){
                    generatedKey = rs.getInt(1);
                    item.setItem_id(generatedKey);
                }
                rs.close();
            }
            
            repStatememt = connection.prepareStatement(reportDetails, Statement.RETURN_GENERATED_KEYS);
            
            repStatememt.setInt(1, currentUserId);
            repStatememt.setInt(2, generatedKey);
            repStatememt.setString(3, report.getDateLost());
            repStatememt.setString(4, report.getLocation());
            repStatememt.setBytes(5, report.getImageData());
            repStatememt.setString(6, report.getItemType());
            repStatememt.executeUpdate();
            
            ResultSet result = repStatememt.getGeneratedKeys();
            
            if(result != null){
                while(result.next()){
                    int report_key = result.getInt(1);
                    report.setReportID(report_key);
                }
                result.close();
            }
            
            
           } 
        
        catch(SQLException er){
            System.out.println("ERROR: " + er);
        } 
            
            
       
        
        finally{
            try{
                if(ps!= null)
                ps.close();
            }
            
            catch(SQLException er){
            System.out.println("ERROR: " + er);
        }
            
        }
    }
    

    
        
       } 
        
        
        
        
        
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

