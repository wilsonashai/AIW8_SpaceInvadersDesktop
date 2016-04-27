<%-- 
    Document   : game
    Created on : Mar 24, 2016, 8:40:09 PM
    Author     : Asha Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alien Invasion</title>
        <link href="assets/css/main.css" type="text/css" rel="stylesheet"/>
       
        <script src="assets/js/jquery-2.2.3.min.js"></script>
        <script> 
            var docWidth;
            var docHeight;
            var TOP_MARGIN = 15;
            var LEFT_MARGIN = 15;
            var alienList = [];
            var resized = false;
            var start = false;
            var SHOT_WIDTH = 12;
            var SHOT_HEIGHT = 23;
            var SHIP_WIDTH = 33;
            var SHIP_HEIGHT = 23;
            var bulletIdSeed = 1;
            var goRight = true;
            var moveDown = false;
            
            $tblAliens = null;
            var intervalAllAliens = null;
            //$shot = null;
            $ship = null; 
            $alien = null;
            $txt = null;
            $temp = null;            
            var bulletClip = [];
            var timer;
            
            $(document).ready(function(){
                docWidth = $(document).width();
                docHeight = $(document).height();
                                
                $(window).resize(function(){
                    docWidth = $(document).width();
                    docHeight = $(document).height();
                    resized = true;
                    initElements();
                });
                
                initElements();
                intervallAllAliens = setInterval(moveAllAliens, 200); // change back to 400              
                $(document).keydown(function(e){
                    //$txt.css("display", "none");
                    
                     if(e.keyCode == 37 || e.keyCode == 39) {
                        moveShip(e);
                     }  
                     //space bar or enter button?
                     if(e.keyCode == 32){
                        createBullet();
                     }
                    
                    e.preventDefault();
                });
                
                $(window).unload(function(){
                    gameOver();
                });
                
            });
            
            function createBullet(){
                $shot = $('<img>');
                $shot.attr("src", "assets/Images/shot.gif");
                $shot.attr("id", "bullet_" + bulletIdSeed);
                                
                var initBulletX = $ship.position().left + $ship.width() / 2 - SHOT_WIDTH / 2;
                var initBulletY = $ship.position().top - SHOT_HEIGHT;
                
                $shot.css({
                   "position" : "absolute",
                   "left" : initBulletX + "px",
                   "top" : initBulletY + "px",
                   "width" : SHOT_WIDTH + "px",
                   "height" : SHOT_HEIGHT + "px"
                })
                $('body').append($shot);
                
                var bullet = {
                    "bulletID" : bulletIdSeed,
                    "intervalID" : 0,
                    "bulletObj" : $shot
                }
                
                bulletIdSeed++;
                bulletClip.push(bullet);
                bullet.intervalID = setInterval(moveBullet, 100, bullet);                
            }
            
            function moveBullet(bullet){
                $firedBullet = $('#bullet_' + bullet.bulletID);
                
                var posY = $firedBullet.position().top;
                var newPosY = posY - 10;
                
                if(newPosY > 5){
                    $firedBullet.css("top", newPosY + "px");
                }
                else{
                    clearInterval(bullet.intervalID);
                    $firedBullet.remove();
                    bulletClip.shift();
                    //record a miss (-1) and call ws_savescore
                }
                var pass = bullet.bulletID;
                //check for collision
                if (checkCollision($firedBullet, pass))
                {
                    clearInterval(bullet.intervalID);
                }
            }
            
            function checkCollision($firedBullet, id){
                var bLeft = $firedBullet.position().left;
                var bTop = $firedBullet.position().top;
                var bRight = bLeft + 12;
                var bBottom = bTop + 23;
                
                //for(i = 0; i < alienList.length; i++){
                for(i = alienList.length; i > 0; i--){
                    var j = i-1;
                    $temp = alienList[j];
                    var aLeft = alienList[j].position().left;
                    var aTop = alienList[j].position().top;
                    var aRight = aLeft + 43;
                    var aBottom = aTop + 29;
                    
                    //r2 = alienList, r1 = firedbullet
                    if(!(bLeft > aRight || bRight < aLeft || 
                            bTop > aBottom || bBottom < aTop)){
                        
                        //$firedBullet.css("display", "none");
                        $("#bullet_" + id).hide();
                        console.log("#bullet_" +id);
                        $("#alien" + j).hide(); 
                        console.log("#alien" + j);
                        alienList.splice(j, 1);
                        console.log("HIT");
                        updateScore();
                        return true;
                    }
                }
                
                return false;
            }
            
            function updateScore(){
                var xhttp = new XMLHttpRequest();
            }
            
            function initElements(){
                $tblAliens = $('#tblAliens');
                $ship = $('#shipImage');
                //$shot = $('#shotImage');
                if(resized === false){
                   drawAllAliens(); 
                }
                $tblAliens.css("top", TOP_MARGIN + "px");
                var tblwidth = 662;
                $tblAliens.css("left", "10px");
                //(docWidth / 2 - tblwidth/2)
                $ship.css("top", (docHeight - $ship.height() - TOP_MARGIN) + "px");
                $ship.css("left", (docWidth / 2 - $ship.width() / 2) + "px");
            }
            
            function drawAllAliens(){
                var k = 0;
                for(var i = 0; i < 4; i++){
                    $tr = $('<tr></tr>');
                    for(var j = 0; j < 12; j++){
                        
                        $td = $('<td></td>');
                        $alien = $('<img>');
                        $alien.attr('src', 'assets/Images/alien.gif');
                        $alien.attr('id', 'alien'+ k);
                        alienList.push($alien);
                        // everytime fire, bullet and see if curr pos of bullet intersects with alien
                        $td.append($alien);
                        $tr.append($td);
                        k++;
                    }
                    $tblAliens.append($tr);
                }
                
                                          
            }
            
            function moveAllAliens(){
                var pos = $tblAliens.position();
                
                if(pos.left < (docWidth - ($tblAliens.width()+ 10)) && goRight == true){
                    $tblAliens.css("left", (pos.left+10) + "px");
                }
                else
                    goRight = false;
                
                if(pos.left > 0 && goRight == false){
                    $tblAliens.css("left", (pos.left-10) + "px");
                }
                else{
                    goRight = true;
                    moveDown = true;
                }
                
                if(moveDown == true && pos.left < 5){
                    $tblAliens.css("top", (pos.top + 10) + "px");
                    moveDown = false;
                }
                
                if(($tblAliens.position().top - 10)>= docHeight)
                {
                    gameOver();
                }
            }
            
            function gameOver(){
                var xttp = new XMLHttpRequest();
//                xttp.onreadystatechange = function(){
//                    if
//                };
//                xttp.open("");
            }
            
            function saveAlienPosition(pos){
                var url = "ws/wssalienwrite";
                var coords = {
                    "x" : pos.left,
                    "y" : pos.top                    
                };

                $.post(url, coords, function(data){
                    //console.log(data);
                });
            }
            
            function moveShip(e) {
                switch(e.which) {
                    case 37: //left
                        var pos = $ship.position();                    
                        $ship.css('left', (pos.left - 10) + 'px');
                    break;

                    case 39:    //right                         
                        var pos = $ship.position();                    
                        $ship.css('left', (pos.left + 10) + 'px');                        
                    break;
                 
                    default: return;    //exit handler
                }
                    
                //saveAlienPosition($ship.position());
            }
        </script>
        
    </head>
    <body>
        <table id="tblAliens">
            
        </table>
<!--        <h3 id="banner">Press any key to begin</h3> -->
<!--        <img src="assets/Images/shot.gif" id="shotImage" />-->
        <img src="assets/Images/ship.gif" id="shipImage" />
    </body>
</html>
