import{t as N,u as k,a as I,r as l,j as e,B as i}from"./index-BJ2M2YpL.js";import{L as F}from"./login-bg-BtmnuXA_.js";import{F as s,I as c,h as d,s as L}from"./http-GtRzVHx2.js";import"./TextArea-VMYqHmOO.js";import"./row-BqiG_bf7.js";const T=()=>{const{token:{colorBgContainer:t}}=N.useToken(),{setUserInfo:x,setToken:p}=k(),a=I(),[u]=l.useState({username:"",password:""}),[m,r]=l.useState(!1),[f]=s.useForm();async function h(n){try{r(!0);const b=(await d.post("/api/user/login",n)).data,{token:o,user_id:v}=b;p(o);const w={params:{user_id:v,token:o}},y=await d.get("/api/user",w);x(y.data.user),L.success("登录成功"),a("/index",{replace:!0})}catch{}finally{r(!1)}}const g=n=>{};return e.jsx("div",{className:"h-full w-full flex items-center justify-center px-[20px]",style:{backgroundImage:"linear-gradient(94deg, #232d3c, #162b5b, #20469c, #2863e3)"},children:e.jsxs("div",{className:"h-[554px] w-full flex overflow-hidden rounded-[10px] lg:w-[960px]",style:{background:t},children:[e.jsx("div",{className:"w-0 flex items-center justify-center overflow-hidden lg:flex-1 lg:overflow-visible",children:e.jsx("img",{width:382,height:382,src:F})}),e.jsx("div",{className:"flex flex-1",style:{background:t},children:e.jsxs(s,{form:f,size:"large",className:"m-auto overflow-hidden rounded-[8px] p-[30px]",style:{background:t},layout:"vertical",initialValues:u,onFinish:h,onFinishFailed:g,children:[e.jsx(s.Item,{children:e.jsx("div",{className:"pb-[20px] text-center text-[22px] text-[#5B86E5] font-bold",children:"智慧运维"})}),e.jsx(s.Item,{label:"",name:"username",rules:[{required:!0,message:"请输入用户名"}],children:e.jsx(c,{prefix:e.jsx("div",{className:"icon-[bi--person] px-[5px] text-[20px]"}),maxLength:11,placeholder:"admin"})}),e.jsx(s.Item,{label:"",name:"password",rules:[{required:!0,message:"请输入密码"}],children:e.jsx(c,{type:"password",prefix:e.jsx("div",{className:"icon-[bi--bag-dash] px-[5px] text-[20px]"}),maxLength:6,placeholder:"123456"})}),e.jsx(s.Item,{children:e.jsxs("div",{className:"flex justify-between space-x-4",children:[e.jsx(i,{type:"primary",htmlType:"submit",block:!0,loading:m,className:"w-full",children:"登录"}),e.jsx(i,{type:"primary",onClick:()=>a("/register"),block:!0,className:"w-full",children:"注册"})]})})]})})]})})};export{T as default};