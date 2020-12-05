import Home from './components/Home'
import About from './components/About'

import LoginForm from '../src/forms/LoginForm'
import RegForm from '../src/forms/RegForm'

import Homepage from './components/Homepage'
import AdminProfile from './components/AdminProfile'
import AdminProfileUpdate from './components/AdminProfileUpdate'
import AdminUsersAuthorites from './components/AdminUsersAuthorities'
import AdminSifrarnik from './components/AdminSifrarnik'

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
        name:'AdminProfile',
        component:AdminProfile
    },
    {
        path:'/profile/:id/update',
        name:'AdminProfileUpdate',
        component:AdminProfileUpdate
    },
    {
        path:'/users',
        name:'UsersAuthorites',
        component:AdminUsersAuthorites
    },
    {
        path:'/car_elements',
        name:'AdminSifrarnik',
        component:AdminSifrarnik
    },
]