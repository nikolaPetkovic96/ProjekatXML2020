import Home from './components/Home'
import About from './components/About'

import LoginForm from '../src/forms/LoginForm'
import RegForm from '../src/forms/RegForm'

import Homepage from './components/Homepage'


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
]