import json
from datetime import datetime
from pathlib import Path
from artifact_tool import Workbook, SpreadsheetFile

# Load the uploaded specification.
json_path = Path("/mnt/data/robust_multi_person_money_tracker_spec(1).json")
with json_path.open("r", encoding="utf-8") as f:
    spec = json.load(f)

output_xlsx = Path("/mnt/data/Multi_Person_Money_Tracker.xlsx")
output_script = Path("/mnt/data/Money_Tracker_Google_Apps_Script.gs")

wb = Workbook.create()

# ---------- Shared styles ----------
dark = "#17324D"
blue = "#1F4E78"
light_blue = "#D9EAF7"
very_light_blue = "#EEF6FC"
green = "#188038"
light_green = "#E6F4EA"
red = "#D93025"
light_red = "#FCE8E6"
gold = "#F4B400"
light_gold = "#FFF4CE"
gray = "#5F6368"
light_gray = "#F3F4F6"
white = "#FFFFFF"
border_color = "#D0D7DE"

title_fmt = {
    "fill": dark,
    "font": {"bold": True, "color": white, "size": 18},
    "horizontal_alignment": "center",
    "vertical_alignment": "center",
}
section_fmt = {
    "fill": blue,
    "font": {"bold": True, "color": white, "size": 11},
    "horizontal_alignment": "center",
    "vertical_alignment": "center",
}
header_fmt = {
    "fill": blue,
    "font": {"bold": True, "color": white, "size": 10},
    "horizontal_alignment": "center",
    "vertical_alignment": "center",
    "wrap_text": True,
    "borders": {
        "top": {"color": border_color, "style": "continuous"},
        "bottom": {"color": border_color, "style": "continuous"},
        "left": {"color": border_color, "style": "continuous"},
        "right": {"color": border_color, "style": "continuous"},
    },
}
body_border_fmt = {
    "borders": {
        "top": {"color": border_color, "style": "continuous"},
        "bottom": {"color": border_color, "style": "continuous"},
        "left": {"color": border_color, "style": "continuous"},
        "right": {"color": border_color, "style": "continuous"},
    },
    "vertical_alignment": "center",
}
editable_fill = "#FFFDF2"
system_fill = "#F4F7FA"

currency_format = '+₹#,##0.00;-₹#,##0.00;+₹0.00'
date_format = "dd-mmm-yyyy hh:mm:ss AM/PM"

# ---------- README ----------
readme = wb.worksheets.add("README")
readme.merge_cells("A1:H1")
readme.get_range("A1").values = [["MULTI-PERSON MONEY TRACKER"]]
readme.get_range("A1:H1").format = title_fmt
readme.get_range("A1:H1").format.row_height = 34

readme.get_range("A3:H3").merge()
readme.get_range("A3").values = [["How to use this workbook"]]
readme.get_range("A3:H3").format = section_fmt

instructions = [
    ["Step", "Action", "Details", "", "", "", "", ""],
    [1, "Upload to Google Drive", "Open this .xlsx file using Google Sheets.", "", "", "", "", ""],
    [2, "Open Apps Script", "Extensions → Apps Script.", "", "", "", "", ""],
    [3, "Paste the script", "Copy the complete content from Money_Tracker_Google_Apps_Script.gs.", "", "", "", "", ""],
    [4, "Run setupMoneyTracker", "Run once and approve permissions. This creates checkboxes, formulas, protections, menu, formatting and the edit trigger.", "", "", "", "", ""],
    [5, "Add people", "Use Money Tracker → Add Person. A new Person_<Name> sheet will be created from Tracker_Template.", "", "", "", "", ""],
    [6, "Enter transactions", "Positive Amount favours ME; negative Amount favours YOU.", "", "", "", "", ""],
    [7, "Settle", "Tick Only_Amount for one transaction or Settlement to settle the complete running balance.", "", "", "", "", ""],
]
readme.get_range("A4:H11").values = instructions
readme.get_range("A4:H4").format = header_fmt
readme.get_range("A5:H11").format = body_border_fmt
readme.get_range("B5:C11").format.wrap_text = True
readme.get_range("A4:A11").format.column_width = 8
readme.get_range("B4:B11").format.column_width = 24
readme.get_range("C4:C11").format.column_width = 70
readme.get_range("D4:H11").format.column_width = 3

readme.get_range("A13:H13").merge()
readme.get_range("A13").values = [["Balance rules"]]
readme.get_range("A13:H13").format = section_fmt
rules = [
    ["Condition", "Meaning", "Display", "Result", "", "", "", ""],
    ["Amount > 0", "Balance favours ME", "Green +₹ amount", "Get = ME", "", "", "", ""],
    ["Amount < 0", "Balance favours YOU", "Red -₹ amount", "Get = YOU", "", "", "", ""],
    ["Only_Amount checked", "That row is individually settled", "Effective amount becomes zero", "Later balances recalculate", "", "", "", ""],
    ["Settlement checked", "Full balance up to that row is settled", "Snapshot saved in Settled_Amount", "Sum resets to zero", "", "", "", ""],
]
readme.get_range("A14:H18").values = rules
readme.get_range("A14:H14").format = header_fmt
readme.get_range("A15:H18").format = body_border_fmt
readme.get_range("A14:D18").format.wrap_text = True
readme.get_range("A14:A18").format.column_width = 22
readme.get_range("B14:B18").format.column_width = 34
readme.get_range("C14:C18").format.column_width = 32
readme.get_range("D14:D18").format.column_width = 28

readme.get_range("A20:H20").merge()
readme.get_range("A20").values = [["Important"]]
readme.get_range("A20:H20").format = {"fill": gold, "font": {"bold": True, "color": "#202124"}, "horizontal_alignment": "center"}
readme.get_range("A21:H23").merge()
readme.get_range("A21").values = [[
    "Excel formulas provide the running balance and colour logic. Automatic timestamps, permanent settlement snapshots, "
    "editor identity, audit logging, true checkboxes and person-sheet creation require the included Google Apps Script."
]]
readme.get_range("A21:H23").format = {
    "fill": light_gold,
    "font": {"color": "#202124"},
    "wrap_text": True,
    "vertical_alignment": "center",
    "horizontal_alignment": "left",
}
readme.freeze_panes.freeze_rows(1)

# ---------- Settings ----------
settings = wb.worksheets.add("Settings")
settings.merge_cells("A1:D1")
settings.get_range("A1").values = [["SETTINGS"]]
settings.get_range("A1:D1").format = title_fmt
settings.get_range("A3:D3").values = [["Setting", "Value", "Purpose", "Editable"]]
settings.get_range("A3:D3").format = header_fmt

settings_rows = [
    ["Timezone", "Asia/Kolkata", "Used for all timestamps", "YES"],
    ["Currency", "₹", "Currency display symbol", "YES"],
    ["Positive_Color", green, "Positive values and ME", "YES"],
    ["Negative_Color", red, "Negative values and YOU", "YES"],
    ["Maximum_Tracker_Rows", 500, "Rows prepared in each person tracker", "YES"],
    ["Owner_Label", "ME", "Spreadsheet owner", "YES"],
    ["Other_Person_Label", "YOU", "Person represented by the current tracker sheet", "YES"],
    ["Calculated_Columns", "Date, Sum, Get, Settled_On, Paid_By, Settled_Amount, Who_Changed", "Script/formula controlled", "NO"],
]
settings.get_range("A4:D11").values = settings_rows
settings.get_range("A4:D11").format = body_border_fmt
settings.get_range("A4:A11").format.column_width = 28
settings.get_range("B4:B11").format.column_width = 28
settings.get_range("C4:C11").format.column_width = 55
settings.get_range("D4:D11").format.column_width = 12
settings.get_range("A4:D11").format.wrap_text = True
settings.freeze_panes.freeze_rows(3)

# ---------- People Master ----------
people = wb.worksheets.add("People_Master")
people.merge_cells("A1:G1")
people.get_range("A1").values = [["PEOPLE MASTER"]]
people.get_range("A1:G1").format = title_fmt
people_headers = spec["recommended_workbook_structure"]["sheets"][0]["columns"]
people.get_range("A3:G3").values = [people_headers]
people.get_range("A3:G3").format = header_fmt
people.get_range("A4:G23").format = body_border_fmt
people.get_range("A4:G23").format.fill = editable_fill
people.get_range("A4:G4").values = [["P001", "Rahul", "", "Person_Rahul", True, 0, datetime(2026, 7, 12, 17, 0, 0)]]
people.get_range("E4:E23").data_validation = {"rule": {"type": "list", "values": ["TRUE", "FALSE"]}}
people.get_range("F4:F23").format.number_format = currency_format
people.get_range("G4:G23").format.number_format = date_format
widths = [14, 24, 34, 28, 12, 18, 24]
for idx, width in enumerate(widths):
    col = chr(ord("A") + idx)
    people.get_range(f"{col}3:{col}23").format.column_width = width
people.freeze_panes.freeze_rows(3)

# ---------- Tracker builder ----------
tracker_headers = spec["person_tracker"]["column_order"]

def format_tracker(sheet, title_text, with_examples=False):
    sheet.merge_cells("A1:L1")
    sheet.get_range("A1").values = [[title_text]]
    sheet.get_range("A1:L1").format = title_fmt
    sheet.get_range("A1:L1").format.row_height = 34
    
    sheet.get_range("A2:L2").values = [tracker_headers]
    sheet.get_range("A2:L2").format = header_fmt
    sheet.get_range("A3:L502").format = body_border_fmt
    
    # Editable/system distinction.
    for col in ["B", "C", "D", "F", "J"]:
        sheet.get_range(f"{col}3:{col}502").format.fill = editable_fill
    for col in ["A", "E", "G", "H", "I", "K", "L"]:
        sheet.get_range(f"{col}3:{col}502").format.fill = system_fill
    
    # Formula columns.
    e_formulas = []
    g_formulas = []
    for r in range(3, 503):
        if r == 3:
            e = f'=IF(B{r}="","",IF(F{r}=TRUE,0,IF(D{r}=TRUE,0,C{r})))'
        else:
            e = f'=IF(B{r}="","",IF(F{r}=TRUE,0,E{r-1}+IF(D{r}=TRUE,0,C{r})))'
        g = f'=IF(B{r}="","",IF(F{r}=TRUE,IF(K{r}<0,"YOU","ME"),IF(E{r}<0,"YOU","ME")))'
        e_formulas.append([e])
        g_formulas.append([g])
    sheet.get_range("E3:E502").formulas = e_formulas
    sheet.get_range("G3:G502").formulas = g_formulas
    
    # Validation. Apps Script converts these to native Google Sheets checkboxes.
    sheet.get_range("D3:D502").data_validation = {"rule": {"type": "list", "values": ["TRUE", "FALSE"]}}
    sheet.get_range("F3:F502").data_validation = {"rule": {"type": "list", "values": ["TRUE", "FALSE"]}}
    
    # Number/date formats.
    for col in ["C", "E", "K"]:
        sheet.get_range(f"{col}3:{col}502").format.number_format = currency_format
    for col in ["A", "H"]:
        sheet.get_range(f"{col}3:{col}502").format.number_format = date_format
    
    # Conditional formatting.
    for col in ["C", "E", "K"]:
        rng = sheet.get_range(f"{col}3:{col}502")
        rng.conditional_formats.add_cell_is({
            "operator": "lessThan",
            "formula": 0,
            "format": {"font": {"color": red, "bold": True}, "fill": light_red},
        })
        rng.conditional_formats.add_cell_is({
            "operator": "greaterThanOrEqual",
            "formula": 0,
            "format": {"font": {"color": green, "bold": True}, "fill": light_green},
        })
    sheet.get_range("G3:G502").conditional_formats.add_custom(
        '=G3="YOU"', {"font": {"color": red, "bold": True}, "fill": light_red}
    )
    sheet.get_range("G3:G502").conditional_formats.add_custom(
        '=G3="ME"', {"font": {"color": green, "bold": True}, "fill": light_green}
    )
    sheet.get_range("I3:I502").conditional_formats.add_custom(
        '=I3="ME"', {"font": {"color": red, "bold": True}, "fill": light_red}
    )
    sheet.get_range("I3:I502").conditional_formats.add_custom(
        '=I3="YOU"', {"font": {"color": green, "bold": True}, "fill": light_green}
    )
    sheet.get_range("D3:D502").conditional_formats.add_custom(
        '=D3=TRUE', {"fill": light_blue, "font": {"bold": True, "color": blue}}
    )
    sheet.get_range("F3:F502").conditional_formats.add_custom(
        '=F3=TRUE', {"fill": light_green, "font": {"bold": True, "color": green}}
    )
    
    # Column widths.
    tracker_widths = {
        "A": 24, "B": 38, "C": 18, "D": 14, "E": 18, "F": 14,
        "G": 12, "H": 24, "I": 12, "J": 34, "K": 20, "L": 30
    }
    for col, width in tracker_widths.items():
        sheet.get_range(f"{col}2:{col}502").format.column_width = width
    
    sheet.get_range("A2:L502").format.wrap_text = True
    sheet.freeze_panes.freeze_rows(2)
    
    if with_examples:
        # Static input/snapshot fields; formula columns E and G remain formula driven.
        sample = [
            [datetime(2026,7,12,17,30), "Lunch paid by me", 500, False, None, False, None, None, None, "", None, "owner@example.com"],
            [datetime(2026,7,12,17,40), "Taxi paid by Rahul", -200, False, None, False, None, None, None, "", None, "rahul@example.com"],
            [datetime(2026,7,12,18,0), "Groceries paid by Rahul", -400, False, None, True, None, datetime(2026,7,12,18,15), "ME", "Paid through UPI", -100, "owner@example.com"],
            [datetime(2026,7,12,18,30), "Coffee paid by me", 150, False, None, False, None, None, None, "", None, "owner@example.com"],
            [datetime(2026,7,12,18,45), "Movie ticket already settled separately", -300, True, None, False, None, None, None, "Individual amount settled", None, "rahul@example.com"],
        ]
        # Write only non-formula columns to preserve formulas.
        for i, row in enumerate(sample, start=3):
            sheet.get_range(f"A{i}:D{i}").values = [[row[0], row[1], row[2], row[3]]]
            sheet.get_range(f"F{i}").values = [[row[5]]]
            sheet.get_range(f"H{i}:L{i}").values = [[row[7], row[8], row[9], row[10], row[11]]]
        # Highlight worked example rows.
        sheet.get_range("A3:L7").format.row_height = 34

template = wb.worksheets.add("Tracker_Template")
format_tracker(template, "TRACKER TEMPLATE", with_examples=False)

rahul = wb.worksheets.add("Person_Rahul")
format_tracker(rahul, "MONEY TRACKER — RAHUL", with_examples=True)

# ---------- Audit Log ----------
audit = wb.worksheets.add("Audit_Log")
audit.merge_cells("A1:M1")
audit.get_range("A1").values = [["AUDIT LOG — APPEND ONLY"]]
audit.get_range("A1:M1").format = title_fmt
audit_headers = spec["audit_log"]["columns"]
audit.get_range("A3:M3").values = [audit_headers]
audit.get_range("A3:M3").format = header_fmt
audit.get_range("A4:M503").format = body_border_fmt
audit.get_range("A4:M503").format.fill = system_fill
audit.get_range("B4:B503").format.number_format = date_format
audit.get_range("L4:L503").format.number_format = currency_format
audit_widths = [38, 24, 30, 26, 13, 24, 24, 24, 24, 36, 18, 24, 38]
for idx, width in enumerate(audit_widths):
    col_num = idx + 1
    # convert to letters for A:M
    col = chr(ord("A") + idx)
    audit.get_range(f"{col}3:{col}503").format.column_width = width
audit.get_range("A3:M503").format.wrap_text = True
audit.freeze_panes.freeze_rows(3)

# ---------- Dashboard ----------
dashboard = wb.worksheets.add("Dashboard")
dashboard.merge_cells("A1:K1")
dashboard.get_range("A1").values = [["MONEY TRACKER DASHBOARD"]]
dashboard.get_range("A1:K1").format = title_fmt
dashboard.get_range("A1:K1").format.row_height = 36

# KPI cards.
kpis = [
    ("A3:B3", "A4:B5", "TOTAL CURRENT BALANCE", "=SUM(C8:C27)", light_blue),
    ("D3:E3", "D4:E5", "ACTIVE PEOPLE", '=COUNTIF(K8:K27,TRUE)', light_green),
    ("G3:H3", "G4:H5", "ME SHOULD GET", '=COUNTIF(D8:D27,"ME")', very_light_blue),
    ("J3:K3", "J4:K5", "YOU SHOULD GET", '=COUNTIF(D8:D27,"YOU")', light_red),
]
for label_range, value_range, label, formula, fill in kpis:
    dashboard.merge_cells(label_range)
    dashboard.merge_cells(value_range)
    dashboard.get_range(label_range.split(":")[0]).values = [[label]]
    dashboard.get_range(label_range).format = {
        "fill": dark, "font": {"bold": True, "color": white, "size": 10},
        "horizontal_alignment": "center", "vertical_alignment": "center"
    }
    dashboard.get_range(value_range.split(":")[0]).formulas = [[formula]]
    dashboard.get_range(value_range).format = {
        "fill": fill, "font": {"bold": True, "color": dark, "size": 18},
        "horizontal_alignment": "center", "vertical_alignment": "center",
        "borders": {
            "top": {"color": border_color, "style": "continuous"},
            "bottom": {"color": border_color, "style": "continuous"},
            "left": {"color": border_color, "style": "continuous"},
            "right": {"color": border_color, "style": "continuous"},
        }
    }
dashboard.get_range("A4:B5").format.number_format = currency_format

dash_headers = spec["dashboard"]["columns"]
dashboard.get_range("A7:K7").values = [dash_headers]
dashboard.get_range("A7:K7").format = header_fmt

for r in range(8, 28):
    pm = r - 4  # Dashboard row 8 -> People_Master row 4
    formulas = [
        f'=IF(People_Master!B{pm}="","",People_Master!B{pm})',
        f'=IF(A{r}="","",People_Master!D{pm})',
        f'=IF(A{r}="","",IFERROR(LOOKUP(2,1/(INDIRECT("\'"&B{r}&"\'!E3:E502")<>""),INDIRECT("\'"&B{r}&"\'!E3:E502")),0))',
        f'=IF(A{r}="","",IF(C{r}<0,"YOU","ME"))',
        f'=IF(A{r}="","",IFERROR(LOOKUP(2,1/(INDIRECT("\'"&B{r}&"\'!K3:K502")<>""),INDIRECT("\'"&B{r}&"\'!K3:K502")),""))',
        f'=IF(A{r}="","",IFERROR(LOOKUP(2,1/(INDIRECT("\'"&B{r}&"\'!H3:H502")<>""),INDIRECT("\'"&B{r}&"\'!H3:H502")),""))',
        f'=IF(A{r}="","",IFERROR(LOOKUP(2,1/(INDIRECT("\'"&B{r}&"\'!I3:I502")<>""),INDIRECT("\'"&B{r}&"\'!I3:I502")),""))',
        f'=IF(A{r}="","",IFERROR(SUMIF(INDIRECT("\'"&B{r}&"\'!C3:C502"),">0",INDIRECT("\'"&B{r}&"\'!C3:C502")),0))',
        f'=IF(A{r}="","",IFERROR(SUMIF(INDIRECT("\'"&B{r}&"\'!C3:C502"),"<0",INDIRECT("\'"&B{r}&"\'!C3:C502")),0))',
        f'=IF(A{r}="","",IFERROR(COUNTIF(INDIRECT("\'"&B{r}&"\'!F3:F502"),TRUE),0))',
        f'=IF(A{r}="","",People_Master!E{pm})',
    ]
    dashboard.get_range(f"A{r}:K{r}").formulas = [formulas]

dashboard.get_range("A8:K27").format = body_border_fmt
dashboard.get_range("A8:K27").format.wrap_text = True
for col in ["C", "E", "H", "I"]:
    dashboard.get_range(f"{col}8:{col}27").format.number_format = currency_format
dashboard.get_range("F8:F27").format.number_format = date_format
dashboard.get_range("C8:C27").conditional_formats.add_cell_is({
    "operator": "lessThan", "formula": 0,
    "format": {"font": {"color": red, "bold": True}, "fill": light_red}
})
dashboard.get_range("C8:C27").conditional_formats.add_cell_is({
    "operator": "greaterThanOrEqual", "formula": 0,
    "format": {"font": {"color": green, "bold": True}, "fill": light_green}
})
dashboard.get_range("D8:D27").conditional_formats.add_custom(
    '=D8="YOU"', {"font": {"color": red, "bold": True}, "fill": light_red}
)
dashboard.get_range("D8:D27").conditional_formats.add_custom(
    '=D8="ME"', {"font": {"color": green, "bold": True}, "fill": light_green}
)
dash_widths = [24, 26, 20, 18, 22, 24, 16, 22, 22, 18, 12]
for idx, width in enumerate(dash_widths):
    col = chr(ord("A") + idx)
    dashboard.get_range(f"{col}7:{col}27").format.column_width = width
dashboard.freeze_panes.freeze_rows(7)

# Add a chart for balances.
try:
    chart = dashboard.charts.add("bar", dashboard.get_range("A7:C27"))
    chart.title_text = "Current Balance by Person"
    chart.has_legend = False
    chart.set_position("M2", "T18")
except Exception:
    # The workbook remains fully usable even if a chart backend is unavailable.
    pass

# ---------- Apps Script source ----------
apps_script = r'''
const MONEY_TRACKER = {
  maxRows: 500,
  firstDataRow: 3,
  templateSheet: 'Tracker_Template',
  peopleSheet: 'People_Master',
  auditSheet: 'Audit_Log',
  dashboardSheet: 'Dashboard',
  settingsSheet: 'Settings',
  readmeSheet: 'README',
  trackerPrefix: 'Person_',
  timezone: 'Asia/Kolkata',
  columns: {
    date: 1,
    description: 2,
    amount: 3,
    onlyAmount: 4,
    sum: 5,
    settlement: 6,
    get: 7,
    settledOn: 8,
    paidBy: 9,
    notes: 10,
    settledAmount: 11,
    whoChanged: 12
  }
};

function onOpen() {
  SpreadsheetApp.getUi()
    .createMenu('Money Tracker')
    .addItem('Setup / Repair Workbook', 'setupMoneyTracker')
    .addItem('Add Person', 'addPersonTracker')
    .addSeparator()
    .addItem('Undo Selected Settlement', 'undoSelectedSettlement')
    .addItem('Refresh Dashboard', 'refreshDashboard')
    .addToUi();
}

function setupMoneyTracker() {
  const ss = SpreadsheetApp.getActive();
  ss.setSpreadsheetTimeZone(MONEY_TRACKER.timezone);
  ensureAuditLog_();

  ss.getSheets()
    .filter(sheet => isTrackerSheet_(sheet))
    .forEach(sheet => prepareTrackerSheet_(sheet));

  installEditTrigger_();
  ss.toast('Money Tracker setup completed.', 'Money Tracker', 5);
}

function addPersonTracker() {
  const ui = SpreadsheetApp.getUi();
  const ss = SpreadsheetApp.getActive();

  const nameResponse = ui.prompt(
    'Add Person',
    'Enter the person name:',
    ui.ButtonSet.OK_CANCEL
  );
  if (nameResponse.getSelectedButton() !== ui.Button.OK) return;

  const personName = nameResponse.getResponseText().trim();
  if (!personName) {
    ui.alert('Person name cannot be blank.');
    return;
  }

  const emailResponse = ui.prompt(
    'Add Person',
    'Enter email address or leave blank:',
    ui.ButtonSet.OK_CANCEL
  );
  if (emailResponse.getSelectedButton() !== ui.Button.OK) return;
  const email = emailResponse.getResponseText().trim();

  const balanceResponse = ui.prompt(
    'Opening Balance',
    'Enter opening balance. Use a positive value when the balance favours ME and a negative value when it favours YOU.',
    ui.ButtonSet.OK_CANCEL
  );
  if (balanceResponse.getSelectedButton() !== ui.Button.OK) return;

  const openingBalanceText = balanceResponse.getResponseText().trim() || '0';
  const openingBalance = Number(openingBalanceText);
  if (!Number.isFinite(openingBalance)) {
    ui.alert('Opening balance must be a valid number.');
    return;
  }

  const safeName = sanitizeSheetName_(personName);
  const sheetName = MONEY_TRACKER.trackerPrefix + safeName;

  if (ss.getSheetByName(sheetName)) {
    ui.alert('A tracker sheet with this name already exists: ' + sheetName);
    return;
  }

  const template = ss.getSheetByName(MONEY_TRACKER.templateSheet);
  if (!template) {
    ui.alert('Tracker_Template sheet was not found.');
    return;
  }

  const newSheet = template.copyTo(ss).setName(sheetName);
  newSheet.getRange('A1').setValue('MONEY TRACKER — ' + personName.toUpperCase());
  prepareTrackerSheet_(newSheet);

  const peopleSheet = ss.getSheetByName(MONEY_TRACKER.peopleSheet);
  const targetRow = Math.max(peopleSheet.getLastRow() + 1, 4);
  const personId = 'P' + String(targetRow - 3).padStart(3, '0');
  peopleSheet.getRange(targetRow, 1, 1, 7).setValues([[
    personId,
    personName,
    email,
    sheetName,
    true,
    openingBalance,
    new Date()
  ]]);

  if (openingBalance !== 0) {
    const row = MONEY_TRACKER.firstDataRow;
    newSheet.getRange(row, MONEY_TRACKER.columns.date).setValue(new Date());
    newSheet.getRange(row, MONEY_TRACKER.columns.description).setValue('Opening balance');
    newSheet.getRange(row, MONEY_TRACKER.columns.amount).setValue(openingBalance);
    newSheet.getRange(row, MONEY_TRACKER.columns.whoChanged).setValue(getEditor_());
    appendAudit_({
      sheet: sheetName,
      row: row,
      action: 'ADD',
      column: 'Opening_Balance',
      oldValue: '',
      newValue: openingBalance,
      description: 'Opening balance',
      amount: openingBalance,
      balance: openingBalance,
      settlementId: ''
    });
  }

  ss.setActiveSheet(newSheet);
  ss.toast('Created ' + sheetName, 'Money Tracker', 5);
}

function prepareTrackerSheet_(sheet) {
  const start = MONEY_TRACKER.firstDataRow;
  const count = MONEY_TRACKER.maxRows;

  sheet.setFrozenRows(2);

  sheet.getRange(start, MONEY_TRACKER.columns.onlyAmount, count, 1).insertCheckboxes();
  sheet.getRange(start, MONEY_TRACKER.columns.settlement, count, 1).insertCheckboxes();

  sheet.getRange(start, MONEY_TRACKER.columns.date, count, 1)
    .setNumberFormat('dd-mmm-yyyy hh:mm:ss AM/PM');
  sheet.getRange(start, MONEY_TRACKER.columns.settledOn, count, 1)
    .setNumberFormat('dd-mmm-yyyy hh:mm:ss AM/PM');

  [MONEY_TRACKER.columns.amount, MONEY_TRACKER.columns.sum, MONEY_TRACKER.columns.settledAmount]
    .forEach(col => {
      sheet.getRange(start, col, count, 1)
        .setNumberFormat('+₹#,##0.00;-₹#,##0.00;+₹0.00');
    });

  sheet.getRange(start, MONEY_TRACKER.columns.sum)
    .setFormula('=IF(B3="","",IF(F3=TRUE,0,IF(D3=TRUE,0,C3)))');

  if (count > 1) {
    sheet.getRange(start + 1, MONEY_TRACKER.columns.sum)
      .setFormula('=IF(B4="","",IF(F4=TRUE,0,E3+IF(D4=TRUE,0,C4)))');
    sheet.getRange(start + 1, MONEY_TRACKER.columns.sum, count - 1, 1).fillDown();
  }

  sheet.getRange(start, MONEY_TRACKER.columns.get)
    .setFormula('=IF(B3="","",IF(F3=TRUE,IF(K3<0,"YOU","ME"),IF(E3<0,"YOU","ME")))');
  sheet.getRange(start, MONEY_TRACKER.columns.get, count, 1).fillDown();

  const warningColumns = [
    MONEY_TRACKER.columns.date,
    MONEY_TRACKER.columns.sum,
    MONEY_TRACKER.columns.get,
    MONEY_TRACKER.columns.settledOn,
    MONEY_TRACKER.columns.paidBy,
    MONEY_TRACKER.columns.settledAmount,
    MONEY_TRACKER.columns.whoChanged
  ];

  warningColumns.forEach(col => {
    const range = sheet.getRange(start, col, count, 1);
    const existing = range.getProtections(SpreadsheetApp.ProtectionType.RANGE);
    if (!existing.length) {
      range.protect()
        .setDescription('System controlled column')
        .setWarningOnly(true);
    }
  });

  applyConditionalFormatting_(sheet);
}

function moneyTrackerEditTrigger(e) {
  if (!e || !e.range) return;

  const sheet = e.range.getSheet();
  if (!isTrackerSheet_(sheet)) return;

  const row = e.range.getRow();
  const col = e.range.getColumn();
  if (row < MONEY_TRACKER.firstDataRow || col > MONEY_TRACKER.columns.whoChanged) return;

  const editor = getEditor_();
  const monitored = [
    MONEY_TRACKER.columns.description,
    MONEY_TRACKER.columns.amount,
    MONEY_TRACKER.columns.onlyAmount,
    MONEY_TRACKER.columns.settlement,
    MONEY_TRACKER.columns.notes
  ];

  if (col === MONEY_TRACKER.columns.description) {
    const description = String(e.range.getDisplayValue() || '').trim();
    const dateCell = sheet.getRange(row, MONEY_TRACKER.columns.date);

    if (description && dateCell.isBlank()) dateCell.setValue(new Date());
    if (!description) dateCell.clearContent();
  }

  if (monitored.includes(col)) {
    sheet.getRange(row, MONEY_TRACKER.columns.whoChanged).setValue(editor);
  }

  if (col === MONEY_TRACKER.columns.settlement) {
    handleSettlementEdit_(e, sheet, row, editor);
    return;
  }

  let action = 'EDIT';
  const newValue = e.value === undefined ? '' : e.value;
  if (e.oldValue === undefined && newValue !== '') action = 'ADD';
  if (newValue === '') action = 'CLEAR';
  if (col === MONEY_TRACKER.columns.onlyAmount && String(newValue).toUpperCase() === 'TRUE') {
    action = 'ONLY_AMOUNT_SETTLED';
  }

  appendAudit_({
    sheet: sheet.getName(),
    row: row,
    action: action,
    column: sheet.getRange(2, col).getDisplayValue(),
    oldValue: e.oldValue === undefined ? '' : e.oldValue,
    newValue: newValue,
    description: sheet.getRange(row, MONEY_TRACKER.columns.description).getDisplayValue(),
    amount: numericValue_(sheet.getRange(row, MONEY_TRACKER.columns.amount).getValue()),
    balance: calculateBalanceBeforeSettlement_(sheet, row),
    settlementId: ''
  });
}

function handleSettlementEdit_(e, sheet, row, editor) {
  const checked = String(e.value).toUpperCase() === 'TRUE';
  const settledAmountCell = sheet.getRange(row, MONEY_TRACKER.columns.settledAmount);
  const settlementCell = sheet.getRange(row, MONEY_TRACKER.columns.settlement);

  if (!checked) {
    if (!settledAmountCell.isBlank()) {
      settlementCell.setValue(true);
      SpreadsheetApp.getActive().toast(
        'Completed settlements cannot be unchecked directly. Use Money Tracker → Undo Selected Settlement.',
        'Settlement protected',
        7
      );
    }
    return;
  }

  if (!settledAmountCell.isBlank()) {
    SpreadsheetApp.getActive().toast('This row is already settled.', 'Money Tracker', 5);
    return;
  }

  const description = sheet.getRange(row, MONEY_TRACKER.columns.description).getDisplayValue().trim();
  if (!description) {
    settlementCell.setValue(false);
    SpreadsheetApp.getActive().toast('Enter a Description before settlement.', 'Money Tracker', 5);
    return;
  }

  const balance = calculateBalanceBeforeSettlement_(sheet, row);
  if (Math.abs(balance) < 0.0000001) {
    settlementCell.setValue(false);
    SpreadsheetApp.getActive().toast('The current balance is zero, so no settlement was created.', 'Money Tracker', 5);
    return;
  }

  const paidBy = balance < 0 ? 'ME' : 'YOU';
  const settlementId = Utilities.getUuid();

  settledAmountCell.setValue(balance);
  sheet.getRange(row, MONEY_TRACKER.columns.settledOn).setValue(new Date());
  sheet.getRange(row, MONEY_TRACKER.columns.paidBy).setValue(paidBy);
  sheet.getRange(row, MONEY_TRACKER.columns.whoChanged).setValue(editor);
  SpreadsheetApp.flush();

  appendAudit_({
    sheet: sheet.getName(),
    row: row,
    action: 'BALANCE_SETTLED',
    column: 'Settlement',
    oldValue: e.oldValue === undefined ? '' : e.oldValue,
    newValue: true,
    description: description,
    amount: numericValue_(sheet.getRange(row, MONEY_TRACKER.columns.amount).getValue()),
    balance: balance,
    settlementId: settlementId
  });
}

function calculateBalanceBeforeSettlement_(sheet, row) {
  const previousBalance = row === MONEY_TRACKER.firstDataRow
    ? 0
    : numericValue_(sheet.getRange(row - 1, MONEY_TRACKER.columns.sum).getValue());

  const amount = numericValue_(sheet.getRange(row, MONEY_TRACKER.columns.amount).getValue());
  const onlyAmount = sheet.getRange(row, MONEY_TRACKER.columns.onlyAmount).isChecked();
  return previousBalance + (onlyAmount ? 0 : amount);
}

function undoSelectedSettlement() {
  const ss = SpreadsheetApp.getActive();
  const sheet = ss.getActiveSheet();
  const row = sheet.getActiveRange().getRow();

  if (!isTrackerSheet_(sheet) || row < MONEY_TRACKER.firstDataRow) {
    SpreadsheetApp.getUi().alert('Select a settled transaction row in a Person_<Name> sheet.');
    return;
  }

  const settledAmountCell = sheet.getRange(row, MONEY_TRACKER.columns.settledAmount);
  if (settledAmountCell.isBlank()) {
    SpreadsheetApp.getUi().alert('The selected row does not contain a completed settlement.');
    return;
  }

  const ui = SpreadsheetApp.getUi();
  const response = ui.alert(
    'Undo Settlement',
    'This will restore the running balance and clear Settled_On, Paid_By and Settled_Amount for the selected row.',
    ui.ButtonSet.YES_NO
  );
  if (response !== ui.Button.YES) return;

  const previousSettledAmount = numericValue_(settledAmountCell.getValue());
  const editor = getEditor_();

  sheet.getRange(row, MONEY_TRACKER.columns.settlement).setValue(false);
  sheet.getRange(row, MONEY_TRACKER.columns.settledOn).clearContent();
  sheet.getRange(row, MONEY_TRACKER.columns.paidBy).clearContent();
  settledAmountCell.clearContent();
  sheet.getRange(row, MONEY_TRACKER.columns.whoChanged).setValue(editor);
  SpreadsheetApp.flush();

  appendAudit_({
    sheet: sheet.getName(),
    row: row,
    action: 'UNDO_SETTLEMENT',
    column: 'Settlement',
    oldValue: true,
    newValue: false,
    description: sheet.getRange(row, MONEY_TRACKER.columns.description).getDisplayValue(),
    amount: numericValue_(sheet.getRange(row, MONEY_TRACKER.columns.amount).getValue()),
    balance: previousSettledAmount,
    settlementId: Utilities.getUuid()
  });
}

function refreshDashboard() {
  SpreadsheetApp.flush();
  SpreadsheetApp.getActive().toast('Dashboard refreshed.', 'Money Tracker', 3);
}

function appendAudit_(event) {
  const sheet = ensureAuditLog_();
  const targetRow = Math.max(sheet.getLastRow() + 1, 4);
  sheet.getRange(targetRow, 1, 1, 13).setValues([[
    Utilities.getUuid(),
    new Date(),
    getEditor_(),
    event.sheet,
    event.row,
    event.action,
    event.column,
    event.oldValue,
    event.newValue,
    event.description,
    event.amount,
    event.balance,
    event.settlementId
  ]]);
}

function ensureAuditLog_() {
  const ss = SpreadsheetApp.getActive();
  let sheet = ss.getSheetByName(MONEY_TRACKER.auditSheet);

  if (!sheet) {
    sheet = ss.insertSheet(MONEY_TRACKER.auditSheet);
    sheet.getRange(1, 1, 1, 13).setValues([[
      'Audit_ID', 'Event_Time', 'Editor', 'Person_Sheet', 'Row_Number',
      'Action', 'Changed_Column', 'Old_Value', 'New_Value',
      'Description_Snapshot', 'Amount_Snapshot',
      'Balance_Before_Action', 'Settlement_ID'
    ]]);
  }
  return sheet;
}

function installEditTrigger_() {
  const ss = SpreadsheetApp.getActive();
  const existing = ScriptApp.getProjectTriggers()
    .filter(trigger => trigger.getHandlerFunction() === 'moneyTrackerEditTrigger');

  existing.forEach(trigger => ScriptApp.deleteTrigger(trigger));

  ScriptApp.newTrigger('moneyTrackerEditTrigger')
    .forSpreadsheet(ss)
    .onEdit()
    .create();
}

function applyConditionalFormatting_(sheet) {
  const start = MONEY_TRACKER.firstDataRow;
  const end = start + MONEY_TRACKER.maxRows - 1;
  const rules = sheet.getConditionalFormatRules()
    .filter(rule => {
      const ranges = rule.getRanges();
      return !ranges.some(range =>
        range.getRow() >= start &&
        range.getColumn() <= MONEY_TRACKER.columns.whoChanged
      );
    });

  const positive = '#188038';
  const negative = '#D93025';
  const positiveFill = '#E6F4EA';
  const negativeFill = '#FCE8E6';

  ['C', 'E', 'K'].forEach(col => {
    const range = sheet.getRange(col + start + ':' + col + end);
    rules.push(
      SpreadsheetApp.newConditionalFormatRule()
        .whenNumberLessThan(0)
        .setFontColor(negative)
        .setBackground(negativeFill)
        .setRanges([range])
        .build()
    );
    rules.push(
      SpreadsheetApp.newConditionalFormatRule()
        .whenNumberGreaterThanOrEqualTo(0)
        .setFontColor(positive)
        .setBackground(positiveFill)
        .setRanges([range])
        .build()
    );
  });

  rules.push(
    SpreadsheetApp.newConditionalFormatRule()
      .whenTextEqualTo('YOU')
      .setFontColor(negative)
      .setBackground(negativeFill)
      .setRanges([
        sheet.getRange('G' + start + ':G' + end)
      ])
      .build()
  );
  rules.push(
    SpreadsheetApp.newConditionalFormatRule()
      .whenTextEqualTo('ME')
      .setFontColor(positive)
      .setBackground(positiveFill)
      .setRanges([
        sheet.getRange('G' + start + ':G' + end)
      ])
      .build()
  );

  sheet.setConditionalFormatRules(rules);
}

function getEditor_() {
  return Session.getActiveUser().getEmail()
    || Session.getEffectiveUser().getEmail()
    || 'UNKNOWN_USER';
}

function isTrackerSheet_(sheet) {
  const name = sheet.getName();
  return name === MONEY_TRACKER.templateSheet || name.startsWith(MONEY_TRACKER.trackerPrefix);
}

function sanitizeSheetName_(name) {
  return name
    .replace(/[\\\/\?\*\[\]\:]/g, ' ')
    .replace(/\s+/g, '_')
    .replace(/^_+|_+$/g, '')
    .substring(0, 80);
}

function numericValue_(value) {
  const number = Number(value);
  return Number.isFinite(number) ? number : 0;
}
'''.strip()

output_script.write_text(apps_script, encoding="utf-8")

script_sheet = wb.worksheets.add("Apps_Script")
script_sheet.merge_cells("A1:F1")
script_sheet.get_range("A1").values = [["GOOGLE APPS SCRIPT — COPY TO EXTENSIONS → APPS SCRIPT"]]
script_sheet.get_range("A1:F1").format = title_fmt
script_sheet.get_range("A3:F3").merge()
script_sheet.get_range("A3").values = [[
    "Run setupMoneyTracker() once after pasting. It installs the edit trigger and enables all automated behaviours."
]]
script_sheet.get_range("A3:F3").format = {
    "fill": light_gold, "font": {"bold": True, "color": "#202124"},
    "wrap_text": True, "vertical_alignment": "center"
}
lines = apps_script.splitlines()
script_sheet.get_range(f"A5:A{4+len(lines)}").values = [[line] for line in lines]
script_sheet.get_range(f"A5:A{4+len(lines)}").format = {
    "font": {"name": "Consolas", "size": 9, "color": "#202124"},
    "fill": "#FAFAFA",
    "wrap_text": False,
}
script_sheet.get_range(f"A5:A{4+len(lines)}").format.column_width = 120
script_sheet.freeze_panes.freeze_rows(4)

# Export.
SpreadsheetFile.export_xlsx(wb).save(str(output_xlsx))

# Compact verification.
print(wb.inspect({
    "kind": "table",
    "range": "Person_Rahul!A1:L8",
    "include": "values,formulas",
    "table_max_rows": 8,
    "table_max_cols": 12,
}).ndjson)

print(wb.inspect({
    "kind": "match",
    "search_term": "#REF!|#DIV/0!|#VALUE!|#NAME\\?|#N/A",
    "options": {"use_regex": True, "max_results": 50},
    "summary": "formula error scan",
}).ndjson)

print(f"Created workbook: {output_xlsx}")
print(f"Created script: {output_script}")
