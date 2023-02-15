<template>
  <div>
    <el-menu
        style="width: 170px;min-height:calc(100vh - 50px)"
        default-active="2"
        class="el-menu-vertical-demo"

    >
      <el-sub-menu index="1">
        <template #title>
          <el-icon><Menu /></el-icon>
          <span>导航</span>
        </template>
        <el-sub-menu index="1-1">
          <template #title>导航1-1</template>
        </el-sub-menu>
      </el-sub-menu>
      <el-menu-item index="2">
        <el-icon><setting /></el-icon>
        <span>导航二</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>导航4</span>
      </el-menu-item>
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