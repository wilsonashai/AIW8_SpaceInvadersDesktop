<%-- 
    Document   : aliens
    Created on : Apr 21, 2016, 6:32:01 PM
    Author     : Asha Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alien Board</title>
        <style>
            #tblAliens{
                position: absolute;
                top: 10px;
                left: 10px;
            }
            
            #tblAliens tr td{
                padding: 5px;
            }
        </style>
        <script src="assets/js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script>
            var alienList = [];
            $tblAliens = null;
            var docWidth;
            var docHeight;
            var intervalAllAliens = null;
            var goRight = true;
            
            $(document).ready(function(){
                docWidth = $(document).width();
                docHeight = $(document).height();
                
                $tblAliens = $('#tblAliens');
                drawAllAliens();
                
                intervallAllAliens = setInterval(moveAllAliens, 100);
                
            });
            
            function drawAllAliens(){
                for(var i = 0; i < 3; i++){
                    $tr = $('<tr></tr>');
                    for(var j = 0; j < 10; j++){
                        $td = $('<td></td>');
                        $alien = $('<img>');
                        $alien.attr('src', 'assets/Images/alien.gif');
                        alienList.push($alien);
                        // everytime fire, bullet and see if curr pos of bullet intersects with alien
                        $td.append($alien);
                        $tr.append($td);
                    }
                    $tblAliens.append($tr);
                }
            }
            
            function moveAllAliens(){
//                var pos = $tblAliens.position();
//                //once reach certain side, need to reverse
//                $tblAliens.css("left", (pos.left+10) + "px");
                
                var pos = $tblAliens.position();
                //once reach certain side, need to reverse
                if(pos.left < (docWidth - ($tblAliens.width()+ 5)) && goRight == true){
                    $tblAliens.css("left", (pos.left+10) + "px");
                }
                else
                    goRight = false;
                
                if(pos.left > 0 && goRight == false){
                    $tblAliens.css("left", (pos.left-10) + "px");
                }
                else{
                    goRight = true;
                    moveDown();
                }
            }
        
        </script>
    </head>
    <body>
        <table id="tblAliens">
            
        </table>
        
        
    </body>
</html>
