<template>
  <div style="padding: 10px">

    <!--功能-->
    <div style="margin: 10px 0">
      <el-button type="primary" @click="add">新增</el-button>
    <el-button type="primary">导入</el-button>
    <el-button type="primary">导出</el-button>
    </div>
    <!--搜索-->
    <div>
      <div style="margin: 10px 0"/>
      <el-input v-model="search" style="width: 30%" placeholder="请输入 " />
      <el-button type="primary" style="margin-left: 5px">查询</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%;padding-top: 5px">
      <el-table-column prop="id" sortable label="ID" />
      <el-table-column prop="username" label="用户名"  />
      <el-table-column prop="nickname" label="昵称" />
      <el-table-column prop="age" label="年龄" />
      <el-table-column prop="sex" label="性别 " />

      <el-table-column prop="address" label="地址" />

      <el-table-column fixed="right" label="操作">
        <template #default="scope">
          <el-button size="small" type="primary"  @click="handleEdit(scope.$index,scope.row)">编辑</el-button>
          <el-popconfirm title="确定删除吗？">
          <template #reference>
          <el-button size="small" type="danger" @click="handDelete(scope.$index,scope.row)">删除</el-button>
        </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
  <div style="margin: 10px 0">
    <el-pagination
        :page-sizes="[5, 10, 20]"
        :small="small"
        :disabled="disabled"
        :current-page="currentPage"
        :page-size="pageSize"
        :background="background"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"/>


    <el-dialog
        v-model="dialogVisible" title="Tips" width="30%">
       <el-form :model="form" label-width="120px">
                <el-form-item label=" 用户名">
           <el-input v-model="form.username" style="width: 80%" /></el-form-item>

         <el-form-item label=" 昵称">
           <el-input v-model="form.nickName" style="width: 80%" /></el-form-item>

         <el-form-item label=" 年龄">
           <el-input v-model="form.age" style="width: 80%" /></el-form-item>

         <el-form-item label=" 性别">
           <el-radio label="男" size="large" v-model="form.sex">男</el-radio>
           <el-radio label="女" size="large" v-model="form.sex">女</el-radio>
           <el-radio label="未知" size="large" v-model="form.sex">未知</el-radio>
         </el-form-item>>
           <el-form-item label=" 地址">
        <el-input type="textarea" v-model="form.address" style="width: 80%" /></el-form-item>


      </el-form>

      <template #footer>
      <span class="dialog-footer">
        <el-button type="primary" @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="save">确定</el-button>

      </span>
      </template>
    </el-dialog>
  </div>
  </div>
</template>

<script>
// @ is an alias to /src

import search from "@element-plus/icons/lib/Search";
 import request from "@/utils/request";

export default {
  name: 'HomeView',
  computed: {
    search() {
      return search
    }
  },
  components: {},
  data(){
    return{
      form:{},
      search:"",
      currentPage: 1,
      total:0,
      dialogVisible:false,
      pageSize:10,
      tableData:[

      ]
      }
    },
  methods:{
    load(){
      request.get("/api/user", {
        pageNum: this.currentPage,
        pageSize: this.pageSize,
        serach:this.search,
      }).then(res =>{
        console.log(res)
      })
    },
    add(){
    this.dialogVisible=true
      this.form={}
    },
    save(){
     request.post("/api/user",this.form).then(res =>{
       console.log(res)
     })
    },
    handleEdit(){
    },
    handleSizeChange(){

    },
    handleCurrentChange(){

    },
    currentPage(){

    }
  }
}
</script>
