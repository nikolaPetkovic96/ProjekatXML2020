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

import AutomobiliAgent from './components/AutomobiliAgent'
import ReservationAgent from './components/RezervacijaAgent'
import CenovnikAgent from './components/CenovnikAgent'
import AdsAgent from './components/OglasiAgent'
import AdsAgentNew from './components/OglasiAgentNew'
import ReportAndStatisticsAgent from './components/IzvestajiIStatistikaAgent'
import CenovnikAgentNew from './components/CenovnikAgentNew'
import ReservationAgentNew from './components/RezervacijaAgentNew'
import AutomobiliAgentNew from './components/AutomobiliAgentNew'
import ReservationAdsOverview from './components/RezervacijaOglasiOverview'
import AutomobiliAgentComments from './components/AutomobiliAgentComments'
import AutomobiliAgentCommentsNew from './components/AutomobiliAgentCommentsNew'


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
        path:'/adsAgent/',
        name:'OglasiAgent',
        component:AdsAgent
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
        path:'/priceAgent/new',
        name:'CenovnikAgentNew',
        component:CenovnikAgentNew
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
    }

]
