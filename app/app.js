const express = require('express')
const request = require('request')
const qs      = require('querystring')
const fs      = require('fs')

const BASE_URL  = 'http://localhost:8080'
const NODE_PORT = 3000
const DATA_FILE = '/Users/pasimann/Documents/Code/vinyl_db/vinyl_database.txt'

const file_data = fs.readFileSync(DATA_FILE).toString().split("\n")

const format_check = value => {
    if (value === "LP") {
        return 1
    }
    if (value === "2LP") {
        return 2
    }
    if (value === "3LP") {
        return 3
    }
    if (value === "4LP") {
        return 4
    }
    if (value === "5LP") {
        return 5
    }
    if (value === "6LP") {
        return 6
    }
    if (value === "7LP") {
        return 7
    }
    if (value === "8LP") {
        return 8
    }
    if (value === "9LP") {
        return 9
    }
    if (value === "10LP") {
        return 10
    }
    if (value === "7\"") {
        return 1
    }
    if (value === "10\"") {
        return 1
    }
    if (value === "12\"") {
        return 1
    }
    if (value === "2x10\"") {
        return 2
    }
    if (value === "2x12\"") {
        return 2
    }
}

const json_array = 
  file_data.map(row => {
    let json_data = {}
    const row_array = row.split("\t")

    json_data[artist]  = row_array[0]
    json_data[title]   = row_array[1]
    json_data[company] = row_array[2]
    json_data[year]    = row_array[3]
    json_data[format]  = row_array[4]
    json_data[heavyweight] = row_array[5] === 'Y' ? true : false 
    json_data[picture]     = row_array[6] === 'Y' ? true : false
    json_data[gatefold]    = row_array[7] === 'Y' ? true : false
    json_data[used]        = row_array[8] === 'Y' ? true : false
    json_data[disks]       = format_check(row_array[4]) 
    
    return json_data
  })


const app = express()

app.get('/hello', (req, res) => {
  res.send('Hello World!')
})

// Java Rest API call example; currently not needed
app.get('/java-api-vinyl-store-search-artist/:artist', (req, res, next) => {
  const query = qs.stringify(req.params)

  request(`${BASE_URL}//vinyl-store-search-artist?${query}`,
    (error, response, body) => {
      if (error) {
        console.log('ERROR with user request!')
        return res.sendStatus(response.statusCode)
      }
      body = JSON.parse(body)
      res.send(body.msg)
  })
})

// Node JS Rest API implementation; reads from local store, text file 

app.get('/vinyl-store-search-by-artist/:artist', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[artist] === value)
  res.send(result)
})

app.get('/vinyl-store-search-by-title/:title', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[title] === value)
  res.send(result)
})

app.get('/vinyl-store-search-by-company/:company', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[company] === value)
  res.send(result)
})

app.get('/vinyl-store-search-by-year/:year', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[year] === value)
  res.send(result)
})

app.get('/vinyl-store-search-by-format/:format', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[format] === value)
  res.send(result)
})

app.get('/vinyl-store-count-by-artist/:artist', (req, res, next) => {
  const value = req.params
  const result = json_array.filter(item => item[artist] === value)
  res.send(result.length)
})

app.get('/vinyl-store-count-total', (req, res, next) => {
  const result = json_array.length
  res.send(result)
})

app.listen(NODE_PORT, () => {
  console.log(`Express app listening port ${NODE_PORT}...`)
})