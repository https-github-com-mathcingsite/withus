<template>
  <v-data-iterator
    :items="items"
    :items-per-page.sync="itemsPerPage"
    :page.sync="page"
    :sort-by="sortBy.toLowerCase()"
    :sort-desc="sortDesc"
    hide-default-footer
  >
    <!-- 
    :search="search"

    <template v-slot:header>
      <v-toolbar plain elevation="0" class="mb-1">
        <v-row>
          <v-col>chips? 버튼..인가..?ㄴ</v-col>
          <v-col md="8"></v-col>
          <v-text-field
            plain
            v-model="search"
            clearable
            flat
            solo-inverted
            hide-details
            prepend-inner-icon="mdi-magnify"
            label="검색"
          ></v-text-field>
        </v-row>
      </v-toolbar>
    </template>
  -->
    <template v-slot:default="props">
      <v-row>
        <v-col
          v-for="item in props.items"
          :key="item.title"
          cols="12"
          sm="6"
          md="4"
          lg="3"
        >
          <v-card>
            <v-card-title class="subheading font-weight-bold">
              {{ item.title }}
            </v-card-title>

            <v-divider></v-divider>

            <v-list dense>
              <v-list-item v-for="(key, index) in filteredKeys" :key="index">
                <v-list-item-content :class="{ 'blue--text': sortBy === key }">
                  {{ key }}:
                </v-list-item-content>
                <v-list-item-content
                  class="align-end"
                  :class="{ 'blue--text': sortBy === key }"
                >
                  {{ item[key.toLowerCase()] }}
                </v-list-item-content>
              </v-list-item>
            </v-list>
          </v-card>
        </v-col>
      </v-row>
    </template>

    <template v-slot:footer>
      <v-row class="mt-2" align="center" justify="center">
        <span class="grey--text">Items per page</span>
        <v-menu offset-y>
          <template v-slot:activator="{ on, attrs }">
            <v-btn
              dark
              text
              color="primary"
              class="ml-2"
              v-bind="attrs"
              v-on="on"
            >
              {{ itemsPerPage }}
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item
              v-for="(number, index) in itemsPerPageArray"
              :key="index"
              @click="updateItemsPerPage(number)"
            >
              <v-list-item-title>{{ number }}</v-list-item-title>
            </v-list-item>
          </v-list>
        </v-menu>

        <v-spacer></v-spacer>

        <v-btn plain @click="formerPage">
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
        <v-btn plain @click="nextPage">
          <v-icon>mdi-chevron-right</v-icon>
        </v-btn>
      </v-row>
    </template>
  </v-data-iterator>
</template>

<script>
export default {
  data() {
    return {
      itemsPerPageArray: [4, 8, 12],
      search: "",
      filter: {},
      sortDesc: false,
      page: 1,
      itemsPerPage: 4,
      sortBy: "title",
      keys: [
        "commentsCnt",
        "viewCnt",
        "min",
        "stacks", //왠지 모든 기술 다 한다음에 true false 해야할것같음
        "ppl",
        "region",
      ],
      items: [
        //일단 dummy data
        {
          title: "프로젝트1",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트2",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트3",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트4",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트5",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트6",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트7",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트8",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트9",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트10",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트11",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트12",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트13",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트14",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트15",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트16",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트17",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트18",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
        {
          title: "프로젝트19",
          commentsCnt: 2,
          viewCnt: 6.0,
          min: 24,
          stacks: "vue",
          ppl: 3,
          region: "무관",
        },
      ],
    };
  },
  computed: {
    numberOfPages() {
      return Math.ceil(this.items.length / this.itemsPerPage);
    },
    filteredKeys() {
      return this.keys.filter((key) => key !== "title");
    },
  },
  methods: {
    nextPage() {
      if (this.page + 1 <= this.numberOfPages) this.page += 1;
    },
    formerPage() {
      if (this.page - 1 >= 1) this.page -= 1;
    },
    updateItemsPerPage(number) {
      this.itemsPerPage = number;
    },
  },
};
</script>

<style></style>
