(window.webpackJsonp=window.webpackJsonp||[]).push([[47],{"./app/gamma/src/components/popover/popover-menu.less":function(e,t,n){var r=n("./node_modules/style-loader/dist/runtime/injectStylesIntoStyleTag.js"),o=n("./node_modules/css-loader/index.js?!./node_modules/postcss-loader/src/index.js?!./node_modules/less-loader/dist/cjs.js?!./app/gamma/src/components/popover/popover-menu.less");"string"==typeof(o=o.__esModule?o.default:o)&&(o=[[e.i,o,""]]);var a={insert:"head",singleton:!1};r(o,a);e.exports=o.locals||{}},"./app/gamma/src/components/popover/popover-menu.tsx":function(e,t,n){"use strict";n.d(t,"c",(function(){return R})),n.d(t,"b",(function(){return g})),n.d(t,"a",(function(){return _}));var r=n("./node_modules/classnames/index.js"),o=n.n(r),a=n("./app/common/lib/util/forward-ref-component.ts"),s=n("./app/common/components/singlespa/router-link.tsx"),c=n("./node_modules/react/index.js"),i=n.n(c),l=n("./app/gamma/src/components/popover/popover-menu.less"),p=n.n(l),d=n("./packages/a11y/index.ts");function u(){return(u=Object.assign||function(e){for(var t=1;t<arguments.length;t++){var n=arguments[t];for(var r in n)Object.prototype.hasOwnProperty.call(n,r)&&(e[r]=n[r])}return e}).apply(this,arguments)}function m(e,t){return function(e){if(Array.isArray(e))return e}(e)||function(e,t){if("undefined"==typeof Symbol||!(Symbol.iterator in Object(e)))return;var n=[],r=!0,o=!1,a=void 0;try{for(var s,c=e[Symbol.iterator]();!(r=(s=c.next()).done)&&(n.push(s.value),!t||n.length!==t);r=!0);}catch(e){o=!0,a=e}finally{try{r||null==c.return||c.return()}finally{if(o)throw a}}return n}(e,t)||function(e,t){if(!e)return;if("string"==typeof e)return f(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);"Object"===n&&e.constructor&&(n=e.constructor.name);if("Map"===n||"Set"===n)return Array.from(n);if("Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n))return f(e,t)}(e,t)||function(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}()}function f(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}function b(e,t){if(null==e)return{};var n,r,o=function(e,t){if(null==e)return{};var n,r,o={},a=Object.keys(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||(o[n]=e[n]);return o}(e,t);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);for(r=0;r<a.length;r++)n=a[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(o[n]=e[n])}return o}var h=function(e){var t=e.children,n=e.description,r=e.rawDescription,a=e.title,s=e.icon;return i.a.createElement(i.a.Fragment,null,s&&i.a.cloneElement(s,{size:"small"}),i.a.createElement("span",{className:o()(p.a.title,n&&p.a.withoutMargins)},a||t),(n||r)&&i.a.createElement("p",{className:p.a.description},n||r))},v=function(e){var t=e.appendSeparator,n=e.children;return i.a.createElement("li",{className:o()(p.a.item,t&&p.a.withSeparator)},n)},R=function(e){var t=e.appendSeparator,n=e.testId,r=e.href,a=e.className,c=e.onClick,l=b(e,["appendSeparator","testId","href","className","onClick"]),f=m(Object(d.a)(),2),R=f[0],g=f[1];return i.a.createElement(v,{appendSeparator:t},i.a.createElement(s.a,u({className:o()(p.a.link,a,R&&p.a.linkFocusRing),href:r,testId:n,onClick:c},g),i.a.createElement(h,l)))},g=Object(a.a)("PopoverMenuButton",(function(e,t){var n=e.appendSeparator,r=e.onClick,a=e.className,s=e.disabled,c=e.testId,l=b(e,["appendSeparator","onClick","className","disabled","testId"]),f=m(Object(d.a)(),2),R=f[0],g=f[1];return i.a.createElement(v,{appendSeparator:n},i.a.createElement("button",u({className:o()(p.a.link,R&&p.a.linkFocusRing,a),disabled:s,onClick:r,"data-test-id":c,ref:t},g),i.a.createElement(h,l)))})),_=function(e){var t=e.className,n=e.children,r=e.testId;return i.a.createElement("nav",{className:t},i.a.createElement("ul",{"data-test-id":r},n))}},"./app/gamma/src/components/popovers/enterprise-menu/enterprise-menu.less":function(e,t,n){var r=n("./node_modules/style-loader/dist/runtime/injectStylesIntoStyleTag.js"),o=n("./node_modules/css-loader/index.js?!./node_modules/postcss-loader/src/index.js?!./node_modules/less-loader/dist/cjs.js?!./app/gamma/src/components/popovers/enterprise-menu/enterprise-menu.less");"string"==typeof(o=o.__esModule?o.default:o)&&(o=[[e.i,o,""]]);var a={insert:"head",singleton:!1};r(o,a);e.exports=o.locals||{}},"./app/gamma/src/components/popovers/enterprise-menu/index.tsx":function(e,t,n){"use strict";n.r(t);var r=n("./app/gamma/src/modules/state/models/enterprises.ts"),o=n("./node_modules/react-redux/es/index.js"),a=n("./app/gamma/src/selectors/enterprises.ts"),s=n("./app/common/lib/util/i18n/index.ts"),c=n("./node_modules/react/index.js"),i=n.n(c),l=n("./app/gamma/src/components/popovers/enterprise-menu/enterprise-menu.less"),p=n.n(l),d=n("./app/gamma/src/components/popover/popover-menu.tsx");function u(e,t){if(!(e instanceof t))throw new TypeError("Cannot call a class as a function")}function m(e,t){for(var n=0;n<t.length;n++){var r=t[n];r.enumerable=r.enumerable||!1,r.configurable=!0,"value"in r&&(r.writable=!0),Object.defineProperty(e,r.key,r)}}function f(e,t){return(f=Object.setPrototypeOf||function(e,t){return e.__proto__=t,e})(e,t)}function b(e,t){return!t||"object"!=typeof t&&"function"!=typeof t?function(e){if(void 0===e)throw new ReferenceError("this hasn't been initialised - super() hasn't been called");return e}(e):t}function h(){if("undefined"==typeof Reflect||!Reflect.construct)return!1;if(Reflect.construct.sham)return!1;if("function"==typeof Proxy)return!0;try{return Date.prototype.toString.call(Reflect.construct(Date,[],(function(){}))),!0}catch(e){return!1}}function v(e){return(v=Object.setPrototypeOf?Object.getPrototypeOf:function(e){return e.__proto__||Object.getPrototypeOf(e)})(e)}var R=Object(s.forTemplate)("header_enterprise_admin_dashboard_menu"),g=function(e){!function(e,t){if("function"!=typeof t&&null!==t)throw new TypeError("Super expression must either be null or a function");e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,writable:!0,configurable:!0}}),t&&f(e,t)}(s,e);var t,n,r,o,a=(t=s,function(){var e,n=v(t);if(h()){var r=v(this).constructor;e=Reflect.construct(n,arguments,r)}else e=n.apply(this,arguments);return b(this,e)});function s(){return u(this,s),a.apply(this,arguments)}return n=s,(r=[{key:"componentDidMount",value:function(){this.props.fetchEnterprises()}},{key:"render",value:function(){var e=this,t=this.props,n=t.isLoading,r=t.enterprises;return n?i.a.createElement("div",null,R("loading")):0===r.length?i.a.createElement("div",null,R("no-enterprises")):i.a.createElement(d.a,{className:p.a.popoverMenu},r.map((function(t){return i.a.createElement(d.c,{key:"enterprise-".concat(t.id),href:"/e/".concat(t.name,"/admin"),onClick:function(){return e.props.onEnterpriseSelected(t.name)}},t.displayName)})))}}])&&m(n.prototype,r),o&&m(n,o),s}(i.a.Component);t.default=Object(o.c)((function(e){return{isLoading:Object(a.i)(e),enterprises:Object(a.a)(e)}}),(function(e){return{fetchEnterprises(){e(Object(r.b)())}}}))(g)},"./node_modules/css-loader/index.js?!./node_modules/postcss-loader/src/index.js?!./node_modules/less-loader/dist/cjs.js?!./app/gamma/src/components/popover/popover-menu.less":function(e,t,n){(t=e.exports=n("./node_modules/css-loader/lib/css-base.js")(!1)).push([e.i,'._2jR0BZMM5cBReR{background-color:transparent;border:none;background:#fff;border-radius:0;box-shadow:none;color:#172b4d;display:block;height:100%;padding:6px 12px;text-align:left;text-decoration:none;width:100%;transition:none;margin:0;outline:0}._2jR0BZMM5cBReR:hover{background-color:transparent;border:none;box-shadow:none;background:rgba(9,30,66,.04)}._2jR0BZMM5cBReR:active{background-color:transparent;border:none;box-shadow:none;background:#e4f0f6}._2jR0BZMM5cBReR._1zydsQvvGuxRTQ:focus{outline:1px dotted #000}@media screen and (-webkit-min-device-pixel-ratio:0){._2jR0BZMM5cBReR._1zydsQvvGuxRTQ:focus{outline:5px auto -webkit-focus-ring-color}}._2jR0BZMM5cBReR[disabled]:active,._2jR0BZMM5cBReR[disabled]:focus,._2jR0BZMM5cBReR[disabled]:hover{background:transparent;color:#a5adba!important}._2jR0BZMM5cBReR[disabled]:active ._225g9OeRSRtf4N svg,._2jR0BZMM5cBReR[disabled]:focus ._225g9OeRSRtf4N svg,._2jR0BZMM5cBReR[disabled]:hover ._225g9OeRSRtf4N svg{color:#a5adba!important}._2jR0BZMM5cBReR[disabled]:active span[name=check],._2jR0BZMM5cBReR[disabled]:focus span[name=check],._2jR0BZMM5cBReR[disabled]:hover span[name=check]{color:#6b778c!important}._2jR0BZMM5cBReR[disabled]:active ._2DBw9GxD3tha0R,._2jR0BZMM5cBReR[disabled]:focus ._2DBw9GxD3tha0R,._2jR0BZMM5cBReR[disabled]:hover ._2DBw9GxD3tha0R{color:#a5adba!important}._1uK2vQ_aMRS2NU{font-size:14px;font-weight:400;line-height:20px}._1uK2vQ_aMRS2NU.l5dERcflZdjE0x{margin:0}._2DBw9GxD3tha0R{color:#5e6c84;font-size:12px;font-weight:400;line-height:16px;margin:4px 0 0;padding:0}._1pCh-d8Vg1eITK:after{background-color:rgba(9,30,66,.13);content:" ";display:block;height:1px;margin:8px auto;width:calc(100% - 20px)}',""]),t.locals={link:"_2jR0BZMM5cBReR",linkFocusRing:"_1zydsQvvGuxRTQ",icon:"_225g9OeRSRtf4N",description:"_2DBw9GxD3tha0R",title:"_1uK2vQ_aMRS2NU",withoutMargins:"l5dERcflZdjE0x",withSeparator:"_1pCh-d8Vg1eITK"}},"./node_modules/css-loader/index.js?!./node_modules/postcss-loader/src/index.js?!./node_modules/less-loader/dist/cjs.js?!./app/gamma/src/components/popovers/enterprise-menu/enterprise-menu.less":function(e,t,n){(t=e.exports=n("./node_modules/css-loader/lib/css-base.js")(!1)).push([e.i,".-lGl2yEhqfdGTe{margin:0 -12px}",""]),t.locals={popoverMenu:"-lGl2yEhqfdGTe"}}}]);
//# sourceMappingURL=enterprise-menu-popover.24829b384dccd3c7f0a3.js.map