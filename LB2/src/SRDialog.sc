;;; Sierra Script 1.0 - (do not remove this comment)
(script# 990)
(include sci.sh)
(use Main)
(use Class_255_0)
(use Print)
(use DIcon)
(use n932)
(use Class_993_0)

(public
	proc990_0 0
)

(local
	gGameSel_83
	local1
	local2
	local3
	local4
	local5
	[local6 4] = [{Restore} {__Save__} {Replace} {Replace}]
	[local10 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)
(procedure (proc990_0 param1 &tmp temp0 [temp1 33] [temp34 100] temp134 [temp135 100] [temp235 5] [temp240 5])
	(asm
code_07ef:
		pushi    #sel_83
		pushi    0
		lag      gGame
		send     4
		sat      temp134
		pushi    #sel_83
		pushi    1
		pushi    1
		lag      gGame
		send     6
		pushi    7
		pushi    0
		pushi    990
		pushi    1
		pushi    0
		pushi    0
		pushi    1
		lea      @temp135
		push    
		callk    Message,  14
		pushi    7
		pushi    0
		pushi    990
		pushi    4
		pushi    0
		pushi    0
		pushi    1
		lea      @temp235
		push    
		callk    Message,  14
		pushi    7
		pushi    0
		pushi    990
		pushi    5
		pushi    0
		pushi    0
		pushi    1
		lea      @temp240
		push    
		callk    Message,  14
		pushi    #sel_30
		pushi    1
		pushi    0
		pushi    198
		pushi    1
		lea      @temp135
		push    
		pushi    200
		pushi    5
		pushi    2
		lea      @temp1
		push    
		lsp      param1
		callk    StrCpy,  4
		push    
		pushi    29
		pushi    0
		pushi    12
		lsp      param1
		pushi    205
		pushi    4
		pushi    1
		lea      @temp235
		push    
		pushi    0
		pushi    26
		pushi    205
		pushi    4
		pushi    0
		lea      @temp240
		push    
		pushi    50
		pushi    26
		pushi    110
		pushi    0
		class    Print
		send     54
		sat      temp0
		pushi    #sel_83
		pushi    1
		lst      temp134
		lag      gGame
		send     6
		lat      temp0
		not     
		bnt      code_088d
		ldi      0
		ret     
code_088d:
		pushi    1
		lea      @temp1
		push    
		callk    StrLen,  2
		not     
		bnt      code_08a0
		pushi    1
		lea      @temp1
		push    
		callk    GetCWD,  2
code_08a0:
		pushi    1
		lea      @temp1
		push    
		callk    ValidPath,  2
		bnt      code_08ba
		pushi    2
		lsp      param1
		lea      @temp1
		push    
		callk    StrCpy,  4
		ldi      1
		ret     
		jmp      code_07ef
code_08ba:
		pushi    7
		pushi    0
		pushi    990
		pushi    2
		pushi    0
		pushi    0
		pushi    1
		lea      @temp135
		push    
		callk    Message,  14
		pushi    3
		lea      @temp34
		push    
		lea      @temp135
		push    
		lea      @temp1
		push    
		callk    Format,  6
		pushi    #sel_30
		pushi    1
		pushi    0
		pushi    198
		pushi    1
		lea      @temp34
		push    
		pushi    110
		pushi    0
		class    Print
		send     16
		jmp      code_07ef
		ret     
	)
)

(procedure (localproc_0675)
	(return
		(cond 
			((== self Restore) 0)
			((localproc_08f3) 1)
			(local3 2)
			(else 3)
		)
	)
)

(procedure (localproc_08f3)
	(if (< local3 20) (CheckFreeSpace global29))
)

(procedure (localproc_0901 &tmp [temp0 100])
	(Message msgGET 990 3 0 0 1 @temp0)
	(Print sel_30: 0 sel_198: @temp0 sel_110:)
)

(class SRDialog of Dialog
	(properties
		sel_20 {SRDialog}
		sel_24 0
		sel_86 0
		sel_23 0
		sel_30 0
		sel_32 0
		sel_187 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_22 0
		sel_143 0
		sel_137 0
		sel_138 0
		sel_188 0
		sel_140 0
	)
	
	(method (sel_110 param1 param2 param3)
		(proc932_3)
		(= gGameSel_83 (gGame sel_83?))
		(gGame sel_83: 1)
		(= sel_32 gLb2Win)
		(= sel_8 0)
		(if
			(==
				(= local3 (GetSaveFiles (gGame sel_20?) param2 param3))
				-1
			)
			(return 0)
		)
		(if (== (= local5 (localproc_0675)) 1)
			(editI
				sel_23: (StrCpy param1 param2)
				sel_30: global23
				sel_180:
				sel_182: 4 4
			)
			(self sel_118: editI sel_180:)
		)
		(selectorI
			sel_23: param2
			sel_30: global23
			sel_180:
			sel_182: 4 (+ sel_8 4)
			sel_29: 2
		)
		(= local2 (+ (selectorI sel_9?) 4))
		(okI
			sel_23: [local6 local5]
			sel_180:
			sel_182: local2 (selectorI sel_6?)
			sel_29:
				(if
				(or (and (== local5 0) (not local3)) (== local5 3))
					0
				else
					3
				)
		)
		(deleteI
			sel_180:
			sel_182: local2 (+ (okI sel_8?) 4)
			sel_29: (if (not local3) 0 else 3)
		)
		(changeDirI
			sel_180:
			sel_182: local2 (+ (deleteI sel_8?) 4)
			sel_29: (& (changeDirI sel_29?) $fff7)
		)
		(cancelI
			sel_180:
			sel_182: local2 (+ (changeDirI sel_8?) 4)
			sel_29: (& (cancelI sel_29?) $fff7)
		)
		(self
			sel_118: selectorI okI deleteI changeDirI cancelI
			sel_180:
		)
		(textI
			sel_23: [local10 local5]
			sel_180: (- (- sel_9 sel_7) 8)
			sel_182: 4 4
		)
		(= local2 (+ (textI sel_8?) 4))
		(self sel_119: 181 0 local2)
		(self sel_118: textI sel_180: sel_192: sel_189: 4 -1)
		(return 1)
	)
	
	(method (sel_57 param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(asm
			pushSelf
			class    Restore
			eq?     
			bnt      code_032c
			lap      argc
			bnt      code_032c
			lap      param1
			bnt      code_032c
			pushi    2
			pushi    0
			pushi    4
			lea      @temp385
			push    
			pushi    990
			pushi    0
			pushi    #sel_20
			pushi    0
			lag      gGame
			send     4
			push    
			callk    Format,  8
			push    
			callk    FileIO,  4
			sat      temp0
			push    
			ldi      65535
			eq?     
			bnt      code_0325
			ret     
code_0325:
			pushi    2
			pushi    1
			lst      temp0
			callk    FileIO,  4
code_032c:
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			not     
			bnt      code_0344
			ldi      65535
			ret     
code_0344:
			lsl      local5
			dup     
			ldi      0
			eq?     
			bnt      code_035a
			lal      local3
			bnt      code_0355
			lofsa    okI
			jmp      code_0373
code_0355:
			lofsa    changeDirI
			jmp      code_0373
code_035a:
			dup     
			ldi      1
			eq?     
			bnt      code_0365
			lofsa    editI
			jmp      code_0373
code_0365:
			dup     
			ldi      2
			eq?     
			bnt      code_0370
			lofsa    okI
			jmp      code_0373
code_0370:
			lofsa    changeDirI
code_0373:
			toss    
			sal      local1
			pushi    #sel_57
			pushi    1
			push    
			super    Dialog,  6
			sal      local2
			pushi    #sel_132
			pushi    1
			pushi    #sel_33
			pushi    0
			lofsa    selectorI
			send     4
			push    
			lofsa    selectorI
			send     6
			sal      local4
			push    
			ldi      18
			mul     
			sat      temp2
			lsl      local2
			lofsa    changeDirI
			eq?     
			bnt      code_03ea
			pushi    #sel_111
			pushi    0
			self     4
			pushi    1
			lsg      global29
			call     proc990_0,  2
			bnt      code_03d5
			pushi    3
			pushi    #sel_20
			pushi    0
			lag      gGame
			send     4
			push    
			lea      @temp3
			push    
			lea      @temp364
			push    
			callk    GetSaveFiles,  6
			sal      local3
			push    
			ldi      65535
			eq?     
			bnt      code_03d5
			ldi      65535
			sat      temp1
			jmp      code_065f
code_03d5:
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_03ea:
			lsl      local5
			ldi      2
			eq?     
			bnt      code_0434
			lsl      local2
			lofsa    okI
			eq?     
			bnt      code_0434
			pushi    #sel_111
			pushi    0
			self     4
			pushi    #sel_57
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			lofsa    GetReplaceName
			send     6
			bnt      code_041f
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_065f
code_041f:
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0434:
			lsl      local5
			ldi      1
			eq?     
			bnt      code_04f5
			lsl      local2
			lofsa    okI
			eq?     
			bt       code_044d
			lsl      local2
			lofsa    editI
			eq?     
			bnt      code_04f5
code_044d:
			pushi    1
			lsp      param1
			callk    StrLen,  2
			push    
			ldi      0
			eq?     
			bnt      code_0478
			pushi    #sel_111
			pushi    0
			self     4
			pushi    0
			call     localproc_0901,  0
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0478:
			ldi      65535
			sat      temp1
			ldi      0
			sal      local2
code_0480:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_049f
			pushi    2
			lsp      param1
			lsl      local2
			ldi      18
			mul     
			leai     @temp3
			push    
			callk    StrCmp,  4
			sat      temp1
			not     
			bnt      code_049b
code_049b:
			+al      local2
			jmp      code_0480
code_049f:
			lat      temp1
			not     
			bnt      code_04ae
			lal      local2
			lati     temp364
			sat      temp1
			jmp      code_065f
code_04ae:
			lsl      local3
			ldi      20
			eq?     
			bnt      code_04bf
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_065f
code_04bf:
			ldi      0
			sat      temp1
code_04c3:
			ldi      1
			bnt      code_065f
			ldi      0
			sal      local2
code_04cc:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_04e1
			lst      temp1
			lal      local2
			lati     temp364
			eq?     
			bnt      code_04dd
code_04dd:
			+al      local2
			jmp      code_04cc
code_04e1:
			lsl      local2
			lal      local3
			eq?     
			bnt      code_04eb
			jmp      code_065f
code_04eb:
			+at      temp1
			jmp      code_04c3
			jmp      code_065f
			jmp      code_0344
code_04f5:
			lsl      local2
			lofsa    deleteI
			eq?     
			bnt      code_060b
			pushi    #sel_111
			pushi    0
			self     4
			pushi    #sel_198
			pushi    1
			lofsa    {Are you sure you want to\ndelete this saved game?}
			push    
			pushi    205
			pushi    4
			pushi    0
			lofsa    { No_}
			push    
			pushi    0
			pushi    30
			pushi    205
			pushi    4
			pushi    1
			lofsa    {Yes}
			push    
			pushi    50
			pushi    30
			pushi    110
			pushi    0
			class    Print
			send     34
			not     
			bnt      code_0545
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_0545:
			pushi    #sel_20
			pushi    1
			pushi    3
			pushi    7
			lea      @temp385
			push    
			pushi    #sel_20
			pushi    0
			lag      gGame
			send     4
			push    
			callk    DeviceInfo,  6
			push    
			pushi    189
			pushi    1
			pushi    2
			pushi    #sel_109
			pushi    0
			class    Class_993_0
			send     4
			sat      temp0
			send     12
			ldi      2570
			sat      temp1
			ldi      0
			sal      local2
code_0577:
			lsl      local2
			lal      local3
			lt?     
			bnt      code_05b8
			lsl      local2
			lal      local4
			ne?     
			bnt      code_05b4
			pushi    #sel_357
			pushi    2
			lal      local2
			leai     @temp364
			push    
			pushi    2
			lat      temp0
			send     8
			pushi    356
			pushi    #sel_1
			lsl      local2
			ldi      18
			mul     
			leai     @temp3
			push    
			lat      temp0
			send     6
			pushi    #sel_357
			pushi    2
			lea      @temp1
			push    
			pushi    1
			lat      temp0
			send     8
code_05b4:
			+al      local2
			jmp      code_0577
code_05b8:
			ldi      65535
			sat      temp1
			pushi    #sel_357
			pushi    2
			lea      @temp1
			push    
			pushi    2
			pushi    360
			pushi    0
			pushi    111
			pushi    0
			lat      temp0
			send     16
			pushi    4
			pushi    8
			lea      @temp385
			push    
			pushi    #sel_20
			pushi    0
			lag      gGame
			send     4
			push    
			lal      local4
			lsti     temp364
			callk    DeviceInfo,  8
			pushi    2
			pushi    4
			lea      @temp385
			push    
			callk    FileIO,  4
			pushi    #sel_110
			pushi    3
			lsp      param1
			lea      @temp3
			push    
			lea      @temp364
			push    
			self     10
			jmp      code_0344
code_060b:
			lsl      local2
			lofsa    okI
			eq?     
			bnt      code_061f
			lal      local4
			lati     temp364
			sat      temp1
			jmp      code_065f
			jmp      code_0344
code_061f:
			lsl      local2
			ldi      65535
			eq?     
			bt       code_062e
			lsl      local2
			lofsa    cancelI
			eq?     
			bnt      code_0637
code_062e:
			ldi      65535
			sat      temp1
			jmp      code_065f
			jmp      code_0344
code_0637:
			lsl      local5
			ldi      1
			eq?     
			bnt      code_0344
			pushi    #sel_33
			pushi    1
			pushi    1
			pushi    2
			lsp      param1
			lat      temp2
			leai     @temp3
			push    
			callk    StrCpy,  4
			push    
			callk    StrLen,  2
			push    
			pushi    80
			pushi    0
			lofsa    editI
			send     10
			jmp      code_0344
code_065f:
			pushi    1
			pushi    993
			callk    DisposeScript,  2
			pushi    #sel_111
			pushi    0
			self     4
			pushi    1
			pushi    990
			callk    DisposeScript,  2
			lat      temp1
			ret     
		)
	)
	
	(method (sel_111)
		(proc932_4)
		(gGame sel_83: gGameSel_83)
		(super sel_111: &rest)
	)
)

(class Restore of SRDialog
	(properties
		sel_20 {Restore}
		sel_24 0
		sel_86 0
		sel_23 {Restore a Game}
		sel_30 0
		sel_32 0
		sel_187 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_22 0
		sel_143 0
		sel_137 0
		sel_138 0
		sel_188 0
		sel_140 0
	)
)

(class Save of SRDialog
	(properties
		sel_20 {Save}
		sel_24 0
		sel_86 0
		sel_23 {Save a Game}
		sel_30 0
		sel_32 0
		sel_187 0
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_22 0
		sel_143 0
		sel_137 0
		sel_138 0
		sel_188 0
		sel_140 0
	)
)

(instance GetReplaceName of Dialog
	(properties
		sel_20 {GetReplaceName}
	)
	
	(method (sel_57 param1 &tmp temp0 gGameSel_83_2)
		(= gGameSel_83_2 (gGame sel_83?))
		(gGame sel_83: 1)
		(= sel_32 gLb2Win)
		(text1 sel_180: sel_182: 4 4)
		(self sel_118: text1 sel_180:)
		(oldName
			sel_23: param1
			sel_30: global23
			sel_180:
			sel_182: 4 sel_8
		)
		(self sel_118: oldName sel_180:)
		(text2 sel_180: sel_182: 4 sel_8)
		(self sel_118: text2 sel_180:)
		(newName
			sel_23: param1
			sel_30: global23
			sel_180:
			sel_182: 4 sel_8
		)
		(self sel_118: newName sel_180:)
		(button1 sel_7: 0 sel_6: 0 sel_180:)
		(button2 sel_7: 0 sel_6: 0 sel_180:)
		(button2
			sel_182: (- sel_9 (+ (button2 sel_9?) 4)) sel_8
		)
		(button1
			sel_182: (- (button2 sel_7?) (+ (button1 sel_9?) 4)) sel_8
		)
		(self
			sel_118: button1 button2
			sel_180:
			sel_192:
			sel_189: 0 -1
		)
		(= temp0 (super sel_57: newName))
		(self sel_111:)
		(if (not (StrLen param1))
			(localproc_0901)
			(= temp0 0)
		)
		(gGame sel_83: gGameSel_83_2)
		(return (if (== temp0 newName) else (== temp0 button1)))
	)
)

(instance selectorI of DSelector
	(properties
		sel_20 {selectorI}
		sel_1 36
		sel_0 8
	)
)

(instance editI of DEdit
	(properties
		sel_20 {editI}
		sel_34 35
	)
)

(instance okI of DButton
	(properties
		sel_20 {okI}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance cancelI of DButton
	(properties
		sel_20 {cancelI}
		sel_23 { Cancel_}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance changeDirI of DButton
	(properties
		sel_20 {changeDirI}
		sel_23 {Change\nDirectory}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance deleteI of DButton
	(properties
		sel_20 {deleteI}
		sel_23 { Delete_}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance textI of DText
	(properties
		sel_20 {textI}
		sel_30 0
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance text1 of DText
	(properties
		sel_20 {text1}
		sel_23 {Replace}
		sel_30 0
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance text2 of DText
	(properties
		sel_20 {text2}
		sel_23 {with:}
		sel_30 0
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance oldName of DText
	(properties
		sel_20 {oldName}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance newName of DEdit
	(properties
		sel_20 {newName}
		sel_34 35
	)
)

(instance button1 of DButton
	(properties
		sel_20 {button1}
		sel_23 {Replace}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance button2 of DButton
	(properties
		sel_20 {button2}
		sel_23 {Cancel}
	)
	
	(method (sel_111)
		(super sel_111: 1)
	)
)
