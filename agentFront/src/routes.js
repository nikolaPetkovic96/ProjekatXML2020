import Home from './components/Home'
import About from './components/About'

import LoginForm from '../src/forms/LoginForm'

import Homepage from './components/Homepage'
import UserProfile from './components/UsrAgentProfile'
import UserProfileUpdate from './components/UsrAgentProfileUpdate'
import Cenovnik from './components/Cenovnik'
import CenovnikNew from './components/CenovnikNew'
import CenovnikEdit from './components/CenovnikEdit'
import Automobili from './components/Automobili'
import AutomobiliNew from './components/AutomobiliNew'
import AutomobiliEdit from './components/AutomobiliEdit'
import AutomobiliDetails from './components/AutomobiliDetails'
import AutomobiliComments from './components/AutomobiliComments'
import AutomobiliCommentsNew from './components/AutomobiliCommentsNew'
import ReportAndStatistics from './components/IzvestajiIStatistika'
import ReportNew from './components/IzvestajiNew'
import Reservation from './components/Rezervacija'
import ReservationNew from './components/RezervacijaNew'
import ReservationDetails from './components/RezervacijaDetails'
import ReservationAdsOverview from './components/RezervacijaOglasiOverview'
import Ads from './components/Oglasi'
import AdsNew from './components/OglasiNew'
import MessagesOvervieNew from './components/PorukeOverviewNew'
import IzvestajiOverview from './components/IzvestajiOverview'

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
        name:'Cenovnik',
        component:Cenovnik
    },
    {
        path:'/price/new',
        name:'CenovnikNew',
        component:CenovnikNew
    },
    {
        path:'/price/:id/edit',
        name:'CenovnikEdit',
        component:CenovnikEdit
    },
    {
        path:'/cars',
        name:'Automobili',
        component:Automobili
    },
    {
        path:'/cars/new',
        name:'AutomobiliNew',
        component:AutomobiliNew
    },
    {
        path:'/cars/:id/edit',
        name:'AutomobiliEdit',
        component:AutomobiliEdit
    },
    {
        path:'/cars/:id/details',
        name:'AutomobiliDetails',
        component:AutomobiliDetails
    },
    {
        // path:'/cars/comments',
        path:'/cars/comments',
        name:'AutomobiliKomentar',
        component:AutomobiliComments
    },
    { 
        path:'/cars/comments/:id/new',
        name:'carNewComment',
        component:AutomobiliCommentsNew
    },
    {
        path:'/reservations/',
        name:'Rezervacija',
        component:Reservation
    },
    {
        path:'/cars/:id/reservation',
        name:'RezervacijaNew',
        component:ReservationNew
    },
    {
        path:'/reservation/:id/details',
        name:'RezervacijaDetails',
        component:ReservationDetails
    },
    //pregled oglasa
    {
        path:'/reservation/ads_overview',
        name:'RezervacijaOglasiOverview',
        component:ReservationAdsOverview
    },

    {
        path:'/ads/',
        name:'Oglasi',
        component:Ads
    },
    {
        path:'/ads/:id/new',
        name:'AdsNew',
        component:AdsNew
    },
    {
        path:'/messages/:id/overview',
        name:'PorukeOverviewNew',
        component:MessagesOvervieNew
    },
    {
        path:'/statistics',
        name:'IzvestajiIStatistike',
        component:ReportAndStatistics
    },
    {
        path:'/statistics/:id/report',
        name:'IzvestajNew',
        component:ReportNew
    },
    {
        path:'/istorijatIzvestaja',
        name:'IzvestajiOverview',
        component:IzvestajiOverview
    }
]