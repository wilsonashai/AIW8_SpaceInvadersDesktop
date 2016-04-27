<%-- 
    Document   : users
    Created on : Apr 21, 2016, 2:13:24 PM
    Author     : Asha Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <script src="assets/js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script> 
            $(document).ready(function(){
                $.getJSON('ws/wsleaders', function(data){
                    $tbl = $('#tblUsers');
                    for(var i = 0; i < data.leaders.length; i++){
                        $tr = $('<tr></tr>');
                        $td = $('<td></td>');
                        $td.html(data.leaders[i].lastName);
                        $tr.append($td);
                        
                        $td = $('<td></td>');
                        $td.html(data.leaders[i].firstName);
                        $tr.append($td);
                        
                        $td = $('<td></td>');
                        $td.html(data.leaders[i].highestScore);
                        $tr.append($td);
                        
                        $tbl.append($tr);
                    }
                    //console.log(data.leaders);
                });
            });
        </script>
    </head>
    <body>
        <table id="tblUsers" cellpadding="3" border=".5">
            <tr>
                <th>Last Name</th>
                <th>First Name</th>
                <th>High Score</th>                
            </tr>
        </table>
    </body>
</html>
