 <template>
    <div id='home'>
        <section id="showcase"> 
            <div class="container">
               <h1>Najbolje softversko rešenje na polju oglašavanja automobila</h1>
                <h5>Ako tražite brz i jednostavan način za iznajmljivanje svojih vozila, pregled statistike o iznajmljivanju, kao i jednostavnu komunikaciju sa korisnicima <span id="AppBold">RentaAgentApp</span> je aplikacija za Vas!</h5>
                </div>
        </section>

        <section id="newsletter">
            <div class="container">
                <h1>Još uvek niste naš član? Postanite odmah...</h1>
                <form>
                    <router-link to='/registration' class="nav-link" exact> <button type='submit' class="btn button_1" id='btnRegistration'>Registration</button> </router-link>
                </form>
            </div>
        </section>

        <section id="boxes">
            <div class="container">
                <div class="box" id='box1'>                        
                    <img src='src/assets/searchIconMain.png'>
                    <h3>Pretraga i filtracija</h3>
                    <p>Velika ponuda opcija za kreiranje i pretragu vozila, oglasa i cenovnika. Lako i brzo dodajte novo vozilo i napravite oglas, koje odgovara vasim potrebama, kroz svega nekoliko klikova!</p>
                </div>
                <div class="box" id='box2'>
                    <img src='src/assets/addCarIcon2.1.png'> 
                    <h3>Oglasi</h3>
                    <p>Jednostavan i brz nacin oglašavanja, uz mogućnost detaljnog opisa vozila u ponudi. Jasan i jednostavan uvid u trenutnu dostupnost oglašavanih vozila. </p>
                </div>
                <div class="box" id='box3'>
                    <img src='src/assets/comment3.1.jpg'> 
                    <h3>Povratne informacije</h3>
                    <p>Brz i jednostavana način komunikacije sa drugim korisnicima, kao i pregled ocena i komentara ostavljenih na Vaša vozila</p>
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
    background-color:gold;
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
    border-bottom:gold 3px solid;
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
    color:#FFD300;
    font-weight: bold;
}


/*Showcase*/

#showcase{
    min-height:400px;
    /*background: url('../images/showcase.jpg') no-repeat 0 -400px;*/
    background-image:url('../assets/showcaseMain.jpg');
    background-repeat: no-repeat;
    background-position: -550px -1410px;
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
 color:#FFD300;
 font-weight: bold;
}


</style>

