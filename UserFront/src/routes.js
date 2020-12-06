import Homepage from './components/Homepage'
import Home from './components/Home'
import Automobili from './components/Automobili'
import NewReservation from './components/NewReservation'
import CarDetails from './components/AutomobiliDetails'

import LoginForm from '../src/forms/LoginForm'
import RegForm from '../src/forms/RegForm'

import About from './components/About'


export default [
    {
        path: '/',
        name:'Home',
        component:Home
    },
    {
        path:'/about',
        name:'About',
        component:About 
    },
    {
        path:'/home', 
        name:'Homepage',
        component:Homepage
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
        path:'/cars',
        name:'Cars',
        component:Automobili
    },
    {
        path:'/cars/:id/reservation',
        name:'New Reservation',
        component:NewReservation
    },
    {
        path:'/cars/:id/details',
        name:'AutomobiliDetails',
        component:CarDetails
    }
]
