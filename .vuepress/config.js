const { getFilesOf } = require('./util.js');

module.exports = {
  base: '/Algorithm/',
  assetsPublicPath: '/',
  title: "2ssue's dev note",
  themeConfig: {
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Blog', link: 'https://2ssue.github.io' },
      { text: 'About me', link: 'https://2ssue.github.io/about' },
    ],
    sidebar: [
      ['/', 'Algorithm'],
      {
        title: 'Baekjoon',
        path: '/docs/baekjoon/',
        children: getFilesOf('docs/baekjoon'),
      },
      {
        title: 'Programmers',
        path: '/docs/programmers/',
        children: getFilesOf('docs/programmers'),
      },
    ],
    repo: '2ssue/Algorithm',
    repoLabel: 'GitHub',
  },
};
