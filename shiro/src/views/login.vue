<template>
    <table>
        
            <span v-if="this.st!=null">{{msg}}</span>
            <tr>
                <td>name</td>
                <td><input v-model="username" type="text" name="username"/></td>
            </tr>

            <tr>
                <td>password</td>
                <td><input v-model="password" type="text" name="password"/></td>
            </tr>
            <tr>

                <td><button @click="login">登录</button></td>
                <td><button @click="manage">请求页面</button></td>
            </tr>
            <span>{{$store.state.sessionId}}</span>
        </table>
</template>

<script>
import axios from "axios"
export default {
    data(){
        return{
            username:"",
            password:""
            
        }
    },
    methods:{
        login(){
            axios({
             url:'http://localhost:8082/login',method:"post",params:{'username':this.username,'password':this.password}
            }).then(res=>{
                console.log(res.data.id)
                this.$store.commit("login",res.data.id)})

        },
        manage(){
            
            axios({
                url:'http://localhost:8082/manage',method:"get"
            }).then(res=>
                console.log(res.data))
        }
    }

}
</script>

<style>

</style>