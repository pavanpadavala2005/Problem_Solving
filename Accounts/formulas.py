# Improve the example dashboard so the included Rahul sample displays immediately
# while keeping dynamic INDIRECT formulas for additional people.
dashboard.get_range("C8").formulas = [[
    '=IFERROR(LOOKUP(2,1/(Person_Rahul!E3:E502<>""),Person_Rahul!E3:E502),0)'
]]
dashboard.get_range("D8").formulas = [['=IF(C8<0,"YOU","ME")']]
dashboard.get_range("E8").formulas = [[
    '=IFERROR(LOOKUP(2,1/(Person_Rahul!K3:K502<>""),Person_Rahul!K3:K502),"")'
]]
dashboard.get_range("F8").formulas = [[
    '=IFERROR(LOOKUP(2,1/(Person_Rahul!H3:H502<>""),Person_Rahul!H3:H502),"")'
]]
dashboard.get_range("G8").formulas = [[
    '=IFERROR(LOOKUP(2,1/(Person_Rahul!I3:I502<>""),Person_Rahul!I3:I502),"")'
]]
dashboard.get_range("H8").formulas = [['=SUMIF(Person_Rahul!C3:C502,">0",Person_Rahul!C3:C502)']]
dashboard.get_range("I8").formulas = [['=SUMIF(Person_Rahul!C3:C502,"<0",Person_Rahul!C3:C502)']]
dashboard.get_range("J8").formulas = [['=COUNTIF(Person_Rahul!F3:F502,TRUE)']]
dashboard.get_range("K8").formulas = [['=People_Master!E4']]
dashboard.get_range("D4").formulas = [['=SUM(K8:K27)']]

SpreadsheetFile.export_xlsx(wb).save(str(output_xlsx))

print(wb.inspect({
    "kind": "table",
    "range": "Dashboard!A1:K10",
    "include": "values,formulas",
    "table_max_rows": 10,   
    "table_max_cols": 11,
}).ndjson)

preview1 = wb.render({"sheet_name": "Dashboard", "range": "A1:T18", "scale": 1})
preview1.save("/mnt/data/money_tracker_dashboard_preview.png")
print("Workbook patched and re-exported.")
