import{r as a,u as c,j as t,B as i}from"./index-C96PFSvo.js";import{S as m}from"./index-CL5EgAiU.js";import{h as d}from"./http-Bwthace3.js";import"./row-DSK-Iw-y.js";import"./index-kaDW5-9q.js";import"./TextArea-C947t_Q3.js";const p=[{title:"维护人员ID",dataIndex:"maintenance_person_id",valueType:"digit",formItemProps:{rules:[{required:!0,message:"用户名为必填项"}]}},{title:"故障ID",dataIndex:"fault_id",valueType:"digit",formItemProps:{rules:[{required:!0,message:"用户名为必填项"}]}}];function I(){const r=a.useRef(),{token:n}=c(),[l,s]=a.useState(!1),u=async e=>{try{s(!0);const o={...e,token:n};await d.post("/api/work_order/create",o)}catch{}finally{s(!1)}};return t.jsxs("div",{children:[t.jsx(m,{layout:"horizontal",labelCol:{span:3},onFinish:u,formRef:r,columns:p,autoFocusFirstInput:!1}),t.jsxs("div",{style:{textAlign:"end"},children:[t.jsx(i,{style:{marginRight:"10px"},onClick:()=>{var e;return(e=r.current)==null?void 0:e.resetFields()},children:"重置"}),t.jsx(i,{type:"primary",onClick:()=>{var e;return(e=r.current)==null?void 0:e.submit()},loading:l,children:"提交"})]})]})}export{I as default};