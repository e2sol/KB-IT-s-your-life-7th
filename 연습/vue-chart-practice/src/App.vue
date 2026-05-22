<template>
  <div style="width: 400px; height: 400px">
    <DoughnutChart :chartData="data" />
  </div>
</template>

<script lang="ts">
import { defineComponent, ref, computed } from 'vue';
import { DoughnutChart } from 'vue-chart-3';
import { Chart, ChartData, registerables } from 'chart.js';

// Chart.js 모듈 등록
Chart.register(...registerables);

export default defineComponent({
  name: 'Home',
  components: { DoughnutChart },
  setup() {
    // 도넛 차트 데이터 정의
    const data = computed<ChartData<'doughnut'>>(() => ({
      labels: ['A', 'B', 'C'],
      datasets: [
        {
          data: [30, 50, 30],
          backgroundColor: ['#77CEFF', '#0079AF', '#123E6B'],
        },
      ],
    }));

    return { data };
  },
});
</script>
