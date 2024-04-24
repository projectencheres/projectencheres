/** @type {import('tailwindcss').Config} */
module.exports = {
  purge: ["./src/**/*.html","./src/**/*.js"],
  content: [
    "./src/**/*.{html,js,thymeleaf}",
    "./src/main/resources/static/css/*.css"
  ],
  darkMode: false,
  theme: {
    extend: {
      spacing: {
        header: "var(--height-header)",
        footer: "var(--height-footer)",
        content: "var(--height-content)",
        desk: "70%",
        mobile: "92%"
      },
      colors: {
        primary: "#E4C59E",
        secondary: "#AF8260",
        tertiary: "#803D3B",
        'main-black': "#322C2B"
      },
      fontSize: {
        menu: ['14px', { lineHeight: 'auto' }],
        title: ['15px', { lineHeight: '61px' }],
        h1: ['38px', { lineHeight: '52px' }],
        'h1-landing': ['32px', { lineHeight: '38' }],
        h2: ['31px', { lineHeight: '41px' }],
        h3: ['20px', { lineHeight: '24px' }],
        h4: ['14px', { lineHeight: '24px' }],
        'h4-link': ['14px', { lineHeight: '22px' }],
        paragraph: ['13px', { lineHeight: '22px' }],
        'p-small': ['10px', { lineHeight: 'auto' }]
      },
      fontFamily: {
        viet: ['BeVietnamPro', 'sans-serif']
      },
      
    },
  },
  plugins: [],
}

