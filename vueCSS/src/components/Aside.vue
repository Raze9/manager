<template>
  <div>
    <el-menu
        style="width: 200px;min-height:calc(100vh - 50px)"
        default-active="user"
        :default-openeds="[1]"
        class="el-menu-vertical-demo">
      <el-sub-menu index="1">
        <template #title>系统管理</template>
        <el-menu-item index="user" :route="{path:'/'}"><template #title>用户管理</template></el-menu-item>

        <el-menu-item index="data" :route="{path:'/'}"><template #title>书籍管理</template></el-menu-item>

      </el-sub-menu>

    </el-menu>
  </div>
</template>

<script>
import {Location, Menu, Setting} from "@element-plus/icons";

export default {
  name: "Aside",
  components: {Menu, Setting, Location}
}
</script>

<style scoped>

</style>