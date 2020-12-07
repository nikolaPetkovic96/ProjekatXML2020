import Home from './components/Home'
import About from './components/About'

import LoginForm from '../src/forms/LoginForm'
import RegForm from '../src/forms/RegForm'

import Homepage from './components/Homepage'
import UserProfile from './components/userProfile'
import UserProfileUpdate from './components/userProfileUpdate'
import Cenovnik from './components/Cenovnik'
import CenovnikNew from './components/CenovnikNew'
import CenovnikEdit from './components/CenovnikEdit'
import Automobili from './components/Automobili'
import AutomobiliNew from './components/AutomobiliNew'
import AutomobiliEdit from './components/AutomobiliEdit'
import AutomobiliDetails from './components/AutomobiliDetails'
import AutomobiliComments from './components/AutomobiliComments'
import AutomobiliCommentsNew from './components/AutomobiliCommentsNew'
import Reservation from './components/Rezervacija'
import ReservationNew from './components/RezervacijaNew'
import Ads from './components/Oglasi'
import AdsNew from './components/OglasiNew'
import Messages from './components/Poruke'
export default [
    {
        path:'/',
        name:'Home',
        component:Home
    },
    {
        path:'/about',
        name:'About',
        component:About 
    },
    {
        path:'/login',
        name:'LoginForm',
        component:LoginForm
    },
    {
        path:'/registration',
        name:'RegistrationForm',
        component:RegForm
    },

    {
        path:'/home',
        name:'Homepage',
        component:Homepage
    },
    {
        path:'/profile',
        name:'UserProfile',
        component:UserProfile
    },
    {
        path:'/profile/:id/update',
        name:'UserProfileUpdate',
        component:UserProfileUpdate
    },
    {
        path:'/price',
        name:'cenovnik',
        component:Cenovnik
    },
    {
        path:'/price/new',
        name:'cenovnikNew',
        component:CenovnikNew
    },
    {
        path:'/price/:id/edit',
        name:'cenovnikEdit',
        component:CenovnikEdit
    },
    {
        path:'/cars',
        name:'automobili',
        component:Automobili
    },
    {
        path:'/cars/new',
        name:'automobiliNew',
        component:AutomobiliNew
    },
    {
        path:'/cars/:id/edit',
        name:'automobiliEdit',
        component:AutomobiliEdit
    },
    {
        // path:'/cars/comments',
        path:'/carComments',
        name:'automobiliKomentar',
        component:AutomobiliComments
    },
    {
        path:'/cars/:id/details',
        name:'automobiliDetails',
        component:AutomobiliDetails
    },
    { 
        path:'/carComments/:id/newComment',
        name:'noviKomentar',
        component:AutomobiliCommentsNew
    },
    {
        path:'/reservations/',
        name:'rezervacija',
        component:Reservation
    },
    {
        path:'/cars/:id/reservation',
        name:'rezervacijaNew',
        component:ReservationNew
    },
    {
        path:'/ads/',
        name:'oglasi',
        component:Ads
    },
    {
        path:'/ads/:id/new',
        name:'AdsNew',
        component:AdsNew
    },

// import Messages from './components/Poruke'
// import MessagesNew from './components/PorukeNew'
    {
        path:'/messages',
        name:'poruke',
        component:Messages
    },
   
]