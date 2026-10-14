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
		(= temp134 (gGame parseLang:))
		(gGame parseLang: 1)
		(Message msgGET 990 1 0 0 1 @temp135) ; "New save-game directory:"
		(Message msgGET 990 4 0 0 1 @temp235) ; "OK"
		(Message msgGET 990 5 0 0 1 @temp240) ; "Cancel"
		(= temp0
			(Print
				font: 0
				addText: @temp135
				addEdit: (StrCpy @temp1 where) 29 0 12 where
				addButton: 1 @temp235 0 26
				addButton: 0 @temp240 50 26
				init:
			)
		)
		(gGame parseLang: temp134)
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
			(Print font: 0 addText: @temp34 init:)
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
	(Print font: 0 addText: @temp0 init:)
)

(class SRDialog of Dialog
	(properties
		name {SRDialog}
	)

	(method (init param1 param2 param3)
		(SaveSubLang)
		(= saveParse (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(= nsBottom 0)
		(if (== (= numGames (GetSaveFiles (gGame name:) param2 param3)) -1)
			(return 0)
		)
		(if (== (= theStatus (localproc_0)) 1)
			(editI
				text: (StrCpy param1 param2)
				font: gSmallFont
				setSize:
				moveTo: 4 4
			)
			(self add: editI setSize:)
		)
		(selectorI
			text: param2
			font: gSmallFont
			setSize:
			moveTo: 4 (+ nsBottom 4)
			state: 2
		)
		(= i (+ (selectorI nsRight:) 4))
		(okI
			text: [okIText theStatus]
			setSize:
			moveTo: i (selectorI nsTop:)
			state:
				(if (or (and (== theStatus 0) (not numGames)) (== theStatus 3))
					0
				else
					3
				)
		)
		(deleteI
			setSize:
			moveTo: i (+ (okI nsBottom:) 4)
			state: (if (not numGames) 0 else 3)
		)
		(changeDirI
			setSize:
			moveTo: i (+ (deleteI nsBottom:) 4)
			state: (& (changeDirI state:) $fff7)
		)
		(cancelI
			setSize:
			moveTo: i (+ (changeDirI nsBottom:) 4)
			state: (& (cancelI state:) $fff7)
		)
		(self add: selectorI okI deleteI changeDirI cancelI setSize:)
		(textI
			text: [textIText theStatus]
			setSize: (- (- nsRight nsLeft) 8)
			moveTo: 4 4
		)
		(= i (+ (textI nsBottom:) 4))
		(self eachElementDo: 181 0 i)
		(self add: textI setSize: center: open: 4 -1)
		(return 1)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 361] [temp364 21] [temp385 140])
		(if (and (== self Restore) argc param1)
			(if
				(==
					(= temp0
						(FileIO fiOPEN (Format @temp385 990 0 (gGame name:))) ; "%ssg.dir"
					)
					-1
				)
				(return)
			)
			(FileIO fiCLOSE temp0)
		)
		(if (not (self init: param1 @temp3 @temp364))
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
			(= i (super doit: default))
			(= temp2 (* (= selected (selectorI indexOf: (selectorI cursor:))) 18))
			(if (== i changeDirI)
				(self dispose:)
				(if
					(and
						(GetDirectory gCurSaveDir)
						(==
							(= numGames
								(GetSaveFiles (gGame name:) @temp3 @temp364)
							)
							-1
						)
					)
					(= temp1 -1)
					(break)
				)
				(self init: param1 @temp3 @temp364)
			else
				(if (and (== theStatus 2) (== i okI))
					(self dispose:)
					(if (GetReplaceName doit: (StrCpy param1 @[temp3 temp2]))
						(= temp1 [temp364 selected])
						(break)
					)
					(self init: param1 @temp3 @temp364)
					(continue)
				)
				(if (and (== theStatus 1) (or (== i okI) (== i editI)))
					(if (== (StrLen param1) 0)
						(self dispose:)
						(localproc_2)
						(self init: param1 @temp3 @temp364)
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
						(self dispose:)
						(if
							(not
								(Print
									addText:
										{Are you sure you want to \ndelete this saved game?}
									addButton: 0 { No } 0 30
									addButton: 1 {Yes} 50 30
									init:
								)
							)
							(self init: param1 @temp3 @temp364)
						else
							((= temp0 (Class_993_0 new:))
								name: (DeviceInfo 7 @temp385 (gGame name:)) ; MakeSaveDirName
								open: 2
							)
							(= temp1 2570)
							(for ((= i 0)) (< i numGames) ((++ i))
								(if (!= i selected)
									(temp0 write: @[temp364 i] 2)
									(temp0 writeString: @[temp3 (* i 18)])
									(temp0 write: @temp1 1)
								)
							)
							(= temp1 -1)
							(temp0 write: @temp1 2 close: dispose:)
							(DeviceInfo
								8 ; MakeSaveFileName
								@temp385
								(gGame name:)
								[temp364 selected]
							)
							(FileIO fiUNLINK @temp385)
							(self init: param1 @temp3 @temp364)
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
							cursor: (StrLen (StrCpy param1 @[temp3 temp2]))
							draw:
						)
					)
				)
			)
		)
		(DisposeScript 993)
		(self dispose:)
		(DisposeScript 990)
		(return temp1)
	)

	(method (dispose)
		(RestoreSubLang)
		(gGame parseLang: saveParse)
		(super dispose: &rest)
	)
)

(class Restore of SRDialog
	(properties
		name {Restore}
		text {Restore a Game}
	)
)

(class Save of SRDialog
	(properties
		name {Save}
		text {Save a Game}
	)
)

(instance GetReplaceName of Dialog
	(properties
		name {GetReplaceName}
	)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 (gGame parseLang:))
		(gGame parseLang: 1)
		(= window gSystemWindow)
		(text1 setSize: moveTo: 4 4)
		(self add: text1 setSize:)
		(oldName text: param1 font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: oldName setSize:)
		(text2 setSize: moveTo: 4 nsBottom)
		(self add: text2 setSize:)
		(newName text: param1 font: gSmallFont setSize: moveTo: 4 nsBottom)
		(self add: newName setSize:)
		(button1 nsLeft: 0 nsTop: 0 setSize:)
		(button2 nsLeft: 0 nsTop: 0 setSize:)
		(button2 moveTo: (- nsRight (+ (button2 nsRight:) 4)) nsBottom)
		(button1 moveTo: (- (button2 nsLeft:) (+ (button1 nsRight:) 4)) nsBottom)
		(self add: button1 button2 setSize: center: open: 0 -1)
		(= temp0 (super doit: newName))
		(self dispose:)
		(if (not (StrLen param1))
			(localproc_2)
			(= temp0 0)
		)
		(gGame parseLang: temp1)
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
		name {selectorI}
		x 36
		y 8
	)
)

(instance editI of DEdit
	(properties
		name {editI}
		max 35
	)
)

(instance okI of DButton
	(properties
		name {okI}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance cancelI of DButton
	(properties
		name {cancelI}
		text { Cancel }
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance changeDirI of DButton
	(properties
		name {changeDirI}
		text {Change \nDirectory}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance deleteI of DButton
	(properties
		name {deleteI}
		text { Delete }
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance textI of DText
	(properties
		name {textI}
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text1 of DText
	(properties
		name {text1}
		text {Replace}
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance text2 of DText
	(properties
		name {text2}
		text {with:}
		font 0
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance oldName of DText
	(properties
		name {oldName}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance newName of DEdit
	(properties
		name {newName}
		max 35
	)
)

(instance button1 of DButton
	(properties
		name {button1}
		text {Replace}
	)

	(method (dispose)
		(super dispose: 1)
	)
)

(instance button2 of DButton
	(properties
		name {button2}
		text {Cancel}
	)

	(method (dispose)
		(super dispose: 1)
	)
)
