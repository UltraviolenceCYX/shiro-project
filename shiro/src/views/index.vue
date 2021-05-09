<template>
<div>
   
    <div v-if="$store.state.username!=null">
        <span>{{username}}欢迎回来</span><br>
        <button @click="logout">logout</button>
    </div>
    
    <a href="/main">main</a><br>
    <a href="/manage">manage</a><br>
    <a href="/administator">administator</a>
</div>


  
</template>

<script>
export default {
    name:'index',
    data(){
        return{
            username:123
        }
    },
    methods:{
        logout(){
            this.$store.commit("logout")
        }
    }
    

}
</script>

<style>

</style>