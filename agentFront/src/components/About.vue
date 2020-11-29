<template>
    <div id='about'>
        <section id="main">
            <div class="container">
               <article id="main-col">
                    <h1 class="page-title">About Us</h1>
                    <p>
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores iste cum aut! Aperiam, possimus expedita veritatis deserunt asperiores officiis. Libero odio praesentium earum impedit soluta, sequi exercitationem quod dicta quisquam?
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam provident harum neque consectetur aperiam amet saepe voluptas sapiente. Perspiciatis odit error reiciendis incidunt? Minus vel quam libero tempore magnam alias!
                    </p>
                    <p class="dark">
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores iste cum aut! Aperiam, possimus expedita veritatis deserunt asperiores officiis. Libero odio praesentium earum impedit soluta, sequi exercitationem quod dicta quisquam?
                        Lorem ipsum dolor sit amet consectetur adipisicing elit. Laboriosam provident harum neque consectetur aperiam amet saepe voluptas sapiente. Perspiciatis odit error reiciendis incidunt? Minus vel quam libero tempore magnam alias!
                    </p>
               </article>

               <aside id="sidebar">
                    <div class="dark">
                        <h3>What we do</h3>
                        <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores iste cum aut! Aperiam, possimus expedita veritatis deserunt asperiores officiis.</p>
                    </div>
                </aside>

            </div>
        </section>
    </div>
</template>
<script>

export default {
    name:'About',
    methods:{

    }
}
</script>
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
    background-color:#e8491d;
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
/* Ostaviti za sada ako ne obrisati */
/*Sidebar*/
aside#sidebar{
    float: right;
    width:30%;
    margin-top:10px;
}

article#main-col{
    float: left;
    width:65%;
}
</style>