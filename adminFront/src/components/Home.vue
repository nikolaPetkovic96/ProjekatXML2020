 <template>
    <div id='home'>
        <section id="showcase"> 
            <div class="container">
                <h1 style="font-weight:bold">Najbolje softversko reše<span style='color:#00bcd4;'>nje na polju </span>oglašavanja<span style='color:#00bcd4;'>  automobila</span> </h1>
                <!-- <h5 style="font-weight:bold;color:#00bcd4;">Ako tražite brz i jednostavan način za iznajmljivanje svojih vozila, pregled statistike o iznajmljivanju, kao i jednostavnu komunikaciju sa korisnicima <span id="AppBold">RentaAgentApp</span> je aplikacija za Vas!</h5> -->
                </div>
        </section>
        
        <section id="newsletter">
            <div class="container">
                <h1>Još uvek niste naš član? Postanite odmah...</h1>
            </div>
        </section>

        <section id="boxes">
            <div class="container">
                <div class="box" id='box1'>                        
                    <img src='src/assets/agentProfileIcon.png'>
                    <h3>Upravljanje korisnicima</h3>
                    <p>Brz i intuitivan način za upravljanje permisijama korisnika, promeni njihovog statusa kao i brisanju profila korisnika...</p>
                </div>
                <div class="box" id='box2'>
                    <img src='src/assets/addAgent.png'> 
                    <h3>Registracija firmi i agenata</h3>
                    <p>Jednostavan i brz način registrovanja novih agenata i agentskih firmi i njohovo dodavanje u sistem.</p>
                </div>
                <div class="box" id='box3'>
                    <img src='src/assets/sifrarnikIcon.jpg'> 
                    <h3>Odrzavanje sifrarnika</h3>
                    <p>Brz i lak način za kreiranje novih i izmenu postojećih modela, marki i klasa automobila, kao i tipova menjača i vrsti goriva.</p>
                </div>
            </div>
        </section>
    </div>
</template>

<script>
export default {
    name: 'Home',
    data:function(){
        return {
        }
    }
}


</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body{
    background-color:#f4f4f4;
    margin:0;
    padding:0;
    font-family: Arial, Helvetica, sans-serif;
    font-size: 15px;
    line-height: 1.5em;
    /*isto*/
    font: 15px 1.5em Arial, Helvetica, sans-serif;
}

/*global*/
.container{
    width:80%;
    margin:auto;
    overflow: hidden;
}

.button_1{
    height:38px;
    background-color:#00bcd4;
    color:#fff;
    border:none;
    padding: 0 20px;
}

.dark{
    padding:15px;
    background-color:#35424a;
    color:#fff;
    margin:10px 0;
}

.button_1:hover{
    background-color:#cccccc;
    color:#fff;
    font-weight: bold;
}
/*Header*/
#main-header{
    background-color:#35424a;
    color:#fff;
    padding-top:30px;
    min-height: 70px;
    border-bottom:#00bcd4 3px solid;
}

#main-header #branding{
    float:left;
    margin:0;
}

ul{
   margin:0;
   padding:0;
}
#main-header li{
    /*ili float:left;*/
    display:inline;
    padding:0 20px 0 20px;;
}

#main-header a{
    text-decoration: none;
    color: #fff;
    text-transform: uppercase;
    font-size:16px;
}

#main-header a:hover{
    color:#cccccc;
    font-weight: bold;
}

#navbar{
    float:right;
    padding-top:10px;
}

#main-header .highlight, #main-header .current a{
    color:#00bcd4;
    font-weight: bold;
}


/*Showcase*/

#showcase{
    min-height:400px;
    background: url('../assets/AdminMainShowcase.png') no-repeat -50px -400px;
    /* background-image:url('../assets/showcaseImage.png'); */
    /* background-repeat: no-repeat;
    background-position: -550px -1410px; */
    text-align: center;
    color:#ffffff;
}

#showcase h1{
    margin-top:100px;
    font-size:55px;
    line-height: 1.5em;
    margin-bottom:10px;
}

#showcase p{
    font-size: 20px;
}

/*Newsletter*/

#newsletter{
    padding:15px;
    background-color:#35424a;
    color:#fff;
}

#newsletter h1{
   float:left;
}

#newsletter form{
    float:right;
    padding-top:5px;
 }

 #newsletter input[type="email"]{
    width:250px;
    padding:4px;
    height:25px;
 }

 /*Boxes*/

#boxes{
    margin-top:20px;
}

#boxes .box{
    float:left;
    width:33.3%;
    padding:10px;
    text-align:center;
    box-sizing: border-box;
}

#boxes .box img{
    width:100px;
}

#boxes #box2 img{
    margin-bottom: 3px;
}

#boxes #box3 img{
    margin-bottom: 15px;
}

#AppBold{
 color:#00bcd4;
 font-weight: bold;
}


</style>

