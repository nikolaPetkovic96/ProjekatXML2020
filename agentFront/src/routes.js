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

import Reservation from './components/Rezervacija'
// import ReservationNew from './components/RezervacijaNew'
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
        path:'/reservations/',
        name:'rezervacija',
        component:Reservation
    },
    // {
    //     path:'/reservations/new',
    //     name:'rezervacijaNew',
    //     component:ReservationNew
    // },
   
]