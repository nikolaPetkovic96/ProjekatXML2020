import Home from './components/Home'
import RegForm from './forms/RegForm'
import LoginForm from './forms/LoginForm'

import Homepage from './components/Homepage'
import UserProfile from './components/UserProfile'
import UserProfileUpdate from './components/UserProfileUpdate'
import Poruke from './components/Poruke' 
import PorukeOverview from './components/PorukeOverview'
import ReservationDetails from './components/RezervacijaDetails'
import Reservation from './components/Rezervacija'
import Automobili from './components/Automobili'
import AutomobiliDetails from './components/AutomobiliDetails'
import ReservationNew from './components/RezervacijaNew'

export default [
    {
        path: '/',
        name:'Home',
        component:Home
    },
    {
        path:'/registration',
        name:'RegForm',
        component:RegForm
    },
    {
        path:'/login',
        name:'LoginForm',
        component:LoginForm
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
        path:'/messages',
        name:'Poruke',
        component:Poruke
    },
    {
        path:'/messages/:id/overview',
        name:'PorukeOverview',
        component:PorukeOverview
    },
    {
        path:'/reservation/:id/details',
        name:'ReservationDetails',
        component:ReservationDetails
    },
    {
        path:'/reservations/',
        name:'Reservation',
        component:Reservation
    },
    {
        path:'/cars',
        name:'Automobili',
        component:Automobili
    },
    {
        path:'/cars/:id/details',
        name:'AutomobiliDetails',
        component:AutomobiliDetails
    },
    {
        path:'/cars/:id/reservation',
        name:'RezervacijaNew',
        component:ReservationNew
    }

]
