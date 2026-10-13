;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 990)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Dialog)
(use Language)
(use File)

(public
	GetDirectory 0
)

(local
	saveParse
	default
	i
	numGames
	selected
	theStatus
	[okIText 4] = [{Restore} {__Save__} {Replace} {Replace}]
	[textIText 4] = [{Select the game that you would like to restore.} {Type the description of this saved game.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.} {This directory/disk can hold no more saved games. You must replace one of your saved games or use Change Directory to save on a different directory/disk.}]
)

(procedure (GetDirectory where &tmp temp0 [temp1 33] [temp34 100] temp134 [temp135 100] [temp235 5] [temp240 5])
	(repeat
		(= temp134 (gGame sel_83:))
		(gGame sel_83: 1)
		(Message msgGET 990 1 0 0 1 @temp135) ; "New save-game directory:"
		(Message msgGET 990 4 0 0 1 @temp235) ; "OK"
		(Message msgGET 990 5 0 0 1 @temp240) ; "Cancel"
		(= temp0
			(Print
				sel_30: 0
				sel_198: @temp135
				sel_200: (StrCpy @temp1 where) 29 0 12 where
				sel_205: 1 @temp235 0 26
				sel_205: 0 @temp240 50 26
				sel_110:
			)
		)
		(gGame sel_83: temp134)
		(if (not temp0)
			(return 0)
		)
		(if (not (StrLen @temp1))
			(GetCWD @temp1)
		)
		(if (ValidPath @temp1)
			(StrCpy where @temp1)
			(return 1)
		else
			(Message msgGET 990 2 0 0 1 @temp135) ; "%s is not a valid directory."
			(Format @temp34 @temp135 @temp1)
			(Print sel_30: 0 sel_198: @temp34 sel_110:)
		)
	)
)

(procedure (localproc_0)
	(return
		(cond
			((== self Restore) 0)
			((localproc_1) 1)
			(numGames 2)
			(else 3)
		)
	)
)

(procedure (localproc_1)
	(if (< numGames 20)
		(CheckFreeSpace gCurSaveDir)
	)
)

(procedure (localproc_2 &tmp [temp0 100])
	(Message msgGET 990 3 0 0 1 @temp0) ; "You must type a description for the game."
	(Print sel_30: 0 sel_198: @temp0 sel_110:)
)

(class SRDialog of Dialog
	(properties
		sel_20 {SRDialog}
	)

	(method (sel_110 param1 param2 param3)
		(SaveSubLang)
		(= saveParse (gGame sel_83:))
		(gGame sel_83: 1)
		(= sel_32 gSystemWindow)
		(= sel_8 0)
		(if (== (= numGames (GetSaveFiles (gGame sel_20:) param2 param3)) -1)
			(return 0)
		)
		(if (== (= theStatus (localproc_0)) 1)
			(editI
				sel_23: (StrCpy param1 param2)
				sel_30: gSmallFont
				sel_180:
				sel_182: 4 4
			)
			(self sel_118: editI sel_180:)
		)
		(selectorI
			sel_23: param2
			sel_30: gSmallFont
			sel_180:
			sel_182: 4 (+ sel_8 4)
			sel_29: 2
		)
		(= i (+ (selectorI sel_9:) 4))
		(okI
			sel_23: [okIText theStatus]
			sel_180:
			sel_182: i (selectorI sel_6:)
			sel_29:
				(if (or (and (== theStatus 0) (not numGames)) (== theStatus 3))
					0
				else
					3
				)
		)
		(deleteI
			sel_180:
			sel_182: i (+ (okI sel_8:) 4)
			sel_29: (if (not numGames) 0 else 3)
		)
		(changeDirI
			sel_180:
			sel_182: i (+ (deleteI sel_8:) 4)
			sel_29: (& (changeDirI sel_29:) $fff7)
		)
		(cancelI
			sel_180:
			sel_182: i (+ (changeDirI sel_8:) 4)
			sel_29: (& (cancelI sel_29:) $fff7)
		)
		(self sel_118: selectorI okI deleteI changeDirI cancelI sel_180:)
		(textI
			sel_23: [textIText theStatus]
			sel_180: (- (- sel_9 sel_7) 8)
			sel_182: 4 4
		)
		(= i (+ (textI sel_8:) 4))
		(self sel_119: 181 0 i)
		(self sel_118: textI sel_180: sel_192: sel_189: 4 -1)
		(return 1)
	)

	(method (sel_57 param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc param1)
			(if
				(==
					(= temp0
						(FileIO fiOPEN (Format @temp385 990 0 (gGame sel_20:))) ; "%ssg.dir"
					)
					-1
				)
				(return)
			)
			(FileIO fiCLOSE temp0)
		)
		(if (not (self sel_110: param1 @temp3 @temp364))
			(return -1)
		)
		(repeat
			(= default
				(switch theStatus
					(0
						(if numGames okI else changeDirI)
					)
					(1 editI)
					(2 okI)
					(else changeDirI)
				)
			)
			(= i (super sel_57: default))
			(= temp2 (* (= selected (selectorI sel_132: (selectorI sel_33:))) 18))
			(if (== i changeDirI)
				(self sel_111:)
				(if
					(and
						(GetDirectory gCurSaveDir)
						(==
							(= numGames
								(GetSaveFiles (gGame sel_20:) @temp3 @temp364)
							)
							-1
						)
					)
					(= temp1 -1)
					(break)
				)
				(self sel_110: param1 @temp3 @temp364)
			else
				(if (and (== theStatus 2) (== i okI))
					(self sel_111:)
					(if (GetReplaceName sel_57: (StrCpy param1 @[temp3 temp2]))
						(= temp1 [temp364 selected])
						(break)
					)
					(self sel_110: param1 @temp3 @temp364)
					(continue)
				)
				(if (and (== theStatus 1) (or (== i okI) (== i editI)))
					(if (== (StrLen param1) 0)
						(self sel_111:)
						(localproc_2)
						(self sel_110: param1 @temp3 @temp364)
						(continue)
					)
					(= temp1 -1)
					(for ((= i 0)) (< i numGames) ((++ i))
						(if (not (= temp1 (StrCmp param1 @[temp3 (* i 18)])))
							(break)
						)
					)
					(if (not temp1)
						(= temp1 [temp364 i])
						(break)
					)
					(if (== numGames 20)
						(= temp1 [temp364 selected])
						(break)
					)
					(for ((= temp1 0)) 1 ((++ temp1))
						(for ((= i 0)) (< i numGames) ((++ i))
							(if (== temp1 [temp364 i])
								(break)
							)
						)
						(if (== i numGames)
							(break)
						)
					)
					(break)
				)
				(cond
					((== i deleteI)
						(self sel_111:)
						(if
							(not
								(Print
									sel_198:
										{Are you sure you want to \ndelete this saved game?}
									sel_205: 0 { No } 0 30
									sel_205: 1 {Yes} 50 30
									sel_110:
								)
							)
							(self sel_110: param1 @temp3 @temp364)
						else
							((= temp0 (Class_993_0 sel_109:))
								sel_20: (DeviceInfo 7 @temp385 (gGame sel_20:)) ; MakeSaveDirName
								sel_189: 2
							)
							(= temp1 2570)
							(for ((= i 0)) (< i numGames) ((++ i))
								(if (!= i selected)
									(temp0 sel_357: @[temp364 i] 2)
									(temp0 sel_356: @[temp3 (* i 18)])
									(temp0 sel_357: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 sel_357: @temp1 2 sel_360: sel_111:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame sel_20:)
								[temp364 selected]
							)
							(FileIO fiUNLINK @temp385)
							(self sel_110: param1 @temp3 @temp364)
						)
					)
					((== i okI)
						(= temp1 [temp364 selected])
						(break)
					)
					((or (== i -1) (== i cancelI))
						(= temp1 -1)
						(break)
					)
					((== theStatus 1)
						(editI
							sel_33: (StrLen (StrCpy param1 @[temp3 temp2]))
							sel_80:
						)
					)
				)
			)
		)
		(DisposeScript 993)
		(self sel_111:)
		(DisposeScript 990)
		(return temp1)
	)

	(method (sel_111)
		(RestoreSubLang)
		(gGame sel_83: saveParse)
		(super sel_111: &rest)
	)
)

(class Restore of SRDialog
	(properties
		sel_20 {Restore}
		sel_23 {Restore a Game}
	)
)

(class Save of SRDialog
	(properties
		sel_20 {Save}
		sel_23 {Save a Game}
	)
)

(instance GetReplaceName of Dialog
	(properties
		sel_20 {GetReplaceName}
	)

	(method (sel_57 param1 &tmp temp0 temp1)
		(= temp1 (gGame sel_83:))
		(gGame sel_83: 1)
		(= sel_32 gSystemWindow)
		(text1 sel_180: sel_182: 4 4)
		(self sel_118: text1 sel_180:)
		(oldName sel_23: param1 sel_30: gSmallFont sel_180: sel_182: 4 sel_8)
		(self sel_118: oldName sel_180:)
		(text2 sel_180: sel_182: 4 sel_8)
		(self sel_118: text2 sel_180:)
		(newName sel_23: param1 sel_30: gSmallFont sel_180: sel_182: 4 sel_8)
		(self sel_118: newName sel_180:)
		(button1 sel_7: 0 sel_6: 0 sel_180:)
		(button2 sel_7: 0 sel_6: 0 sel_180:)
		(button2 sel_182: (- sel_9 (+ (button2 sel_9:) 4)) sel_8)
		(button1 sel_182: (- (button2 sel_7:) (+ (button1 sel_9:) 4)) sel_8)
		(self sel_118: button1 button2 sel_180: sel_192: sel_189: 0 -1)
		(= temp0 (super sel_57: newName))
		(self sel_111:)
		(if (not (StrLen param1))
			(localproc_2)
			(= temp0 0)
		)
		(gGame sel_83: temp1)
		(return
			(if (== temp0 newName)
			else
				(== temp0 button1)
			)
		)
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
		sel_23 { Cancel }
	)

	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance changeDirI of DButton
	(properties
		sel_20 {changeDirI}
		sel_23 {Change \nDirectory}
	)

	(method (sel_111)
		(super sel_111: 1)
	)
)

(instance deleteI of DButton
	(properties
		sel_20 {deleteI}
		sel_23 { Delete }
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
