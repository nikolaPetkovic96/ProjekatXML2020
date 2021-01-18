import Home from './components/Home'
import RegForm from './forms/RegForm'
import LoginForm from './forms/LoginForm'

import Homepage from './components/Homepage'
import UserProfile from './components/UserProfile'
import UserProfileUpdate from './components/UserProfileUpdate'

import Automobili from './components/Automobili'
import AutomobiliDetails from './components/AutomobiliDetails'
import AutomobiliAgent from './components/AutomobiliAgent'
import AutomobiliEdit from './components/AutomobiliEdit'
import AutomobiliAgentNew from './components/AutomobiliAgentNew'

import Poruke from './components/Poruke' 
import PorukeOverview from './components/PorukeOverview'
import ReservationChartDetails from './components/RezervacijaChartDetails'
import ReservationDetails from './components/RezervacijaDetails'
import Reservation from './components/Rezervacija'
import ReservationNew from './components/RezervacijaNew'
import ReservationAgent from './components/RezervacijaAgent'
import CenovnikAgent from './components/CenovnikAgent'
import CenovnikAgentEdit from './components/CenovnikAgentEdit'
import CenovnikAgentNew from './components/CenovnikAgentNew'
import AdsAgent from './components/OglasiAgent'
import AdsAgentNew from './components/OglasiAgentNew'
import ReportAndStatisticsAgent from './components/IzvestajiIStatistikaAgent'
import ReservationAgentNew from './components/RezervacijaAgentNew'

import ReservationAdsOverview from './components/RezervacijaOglasiOverview'
import AutomobiliAgentComments from './components/AutomobiliAgentComments'
import AutomobiliAgentCommentsNew from './components/AutomobiliAgentCommentsNew'
import ShoppingCart from './components/ShoppingCart'

import About from './components/About'


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
        path:'/shoppingCart/reservation/:id/details',
        name:'ReservationChartDetails',
        component:ReservationChartDetails
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
    },
    {
        path:'/carsAgent',
        name:'AutomobiliAgent',
        component:AutomobiliAgent
    },
    {
        path:'/reservationAgent/',
        name:'ReservationAgent',
        component:ReservationAgent
    },
    {
        path:'/priceAgent',
        name:'CenovnikAgent',
        component:CenovnikAgent
    },
    {
        path:'/priceAgent/:id/edit',
        name:'CenovnikEdit',
        component:CenovnikAgentEdit
    },
    {
        path:'/priceAgent/new',
        name:'CenovnikAgentNew',
        component:CenovnikAgentNew
    },
    {
        path:'/adsAgent/',
        name:'OglasiAgent',
        component:AdsAgent
    },
    {
        path:'/ads/:id/new',
        name:'AdsAgentNew',
        component:AdsAgentNew
    },
    {
        path:'/adsAgent/:id/new',
        name:'AdsAgentNew',
        component:AdsAgentNew
    },
    {
        path:'/statisticsAgent',
        name:'IzvestajiIStatistikeAgent',
        component:ReportAndStatisticsAgent
    },
    {
        path:'/cars/:id/reservationAgent',
        name:'RezervacijaAgentNew',
        component:ReservationAgentNew
    },
    {
        path:'/carsAgent/new',
        name:'AutomobiliAgentNew',
        component:AutomobiliAgentNew
    },
    {
        path:'/reservationAgent/ads_overview',
        name:'RezervacijaOglasiOverview',
        component:ReservationAdsOverview
    },
    {
        // path:'/cars/comments',
        path:'/carsAgent/comments',
        name:'AutomobiliAgentKomentar',
        component:AutomobiliAgentComments
    },
    { 
        path:'/carsAgent/comments/:id/new',
        name:'carAgentNewComment',
        component:AutomobiliAgentCommentsNew
    },
    {
        path:'/shoppingCart',
        name:'shoppingCart',
        component: ShoppingCart
    },
    {
        path:'/cars/:id/edit',
        name:'AutomobiliEdit',
        component:AutomobiliEdit
    },
    {
        path:'/about',
        name:'About',
        component:About 
    }

]
