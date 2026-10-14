;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 994)
(include sci.sh)
(use Main)
(use Print)
(use Dialog)
(use Polygon)
(use Sound)
(use Save)
(use Motion)
(use Inventory)
(use User)
(use System)

(procedure (PromptForDiskChange saveDisk &tmp ret [saveDevice 40] [curDevice 40] str [buf1 40] [buf2 10] [buf3 5])
	(= str (Memory memALLOC_CRIT (if 0 200 else 80)))
	(= ret 1)
	(DeviceInfo diGET_DEVICE gCurSaveDir @saveDevice)
	(DeviceInfo diGET_CURRENT_DEVICE @curDevice)
	(if
		(and
			(DeviceInfo diIS_FLOPPY @curDevice)
			(or
				(DeviceInfo diPATHS_EQUAL @saveDevice @curDevice)
				(not (DeviceInfo 6 (gGame name:))) ; SaveDirMounted
			)
		)
		(Message msgGET 994 6 0 0 1 @buf1) ; "Insert the %s disk in drive %s."
		(Message msgGET 994 7 0 0 1 @buf2) ; "SAVE GAME"
		(Message msgGET 994 8 0 0 1 @buf3) ; "GAME"
		(Format str @buf1 (if saveDisk @buf2 else @buf3) @saveDevice)
		(Load rsFONT gUserFont)
		(DeviceInfo 4) ; CloseDevice
		(Message msgGET 994 2 0 0 1 @buf1) ; "OK"
		(Message msgGET 994 4 0 0 1 @buf2) ; "Cancel"
		(Message msgGET 994 5 0 0 1 @buf3) ; "Change Directory"
		(if
			(==
				(= ret
					(if saveDisk
						(Print
							font: 0
							addText: str
							addButton: 1 @buf1 0 40
							addButton: 0 @buf2 30 40
							addButton: 2 @buf3
							init:
						)
					else
						(Print
							font: 0
							addText: str
							addButton: 1 @buf1 0 40
							init:
						)
					)
				)
				2
			)
			(= ret (GetDirectory gCurSaveDir))
		)
	)
	(Memory memFREE str)
	(return ret)
)

(instance cast of EventHandler
	(properties
		name {cast}
	)
)

(instance features of EventHandler
	(properties
		name {features}
	)
)

(instance theDoits of EventHandler
	(properties
		name {theDoits}
	)
)

(instance sFeatures of EventHandler
	(properties
		name {sFeatures}
	)

	(method (delete param1)
		(super delete: param1)
		(if
			(and
				gUseSortedFeatures
				(param1 isKindOf: Collect)
				(not (OneOf param1 gRegions gLocales))
			)
			(param1 release: dispose:)
		)
	)
)

(class Sounds of EventHandler
	(properties
		name {Sounds}
	)

	(method (pause param1)
		(self eachElementDo: 96 mayPause (if argc param1 else 1))
	)
)

(instance mayPause of Code
	(properties
		name {mayPause}
	)

	(method (doit param1 param2)
		(if (not (& (param1 flags:) $0001))
			(param1 pause: param2)
		)
	)
)

(instance regions of EventHandler
	(properties
		name {regions}
	)
)

(instance locales of EventHandler
	(properties
		name {locales}
	)
)

(instance addToPics of EventHandler
	(properties
		name {addToPics}
	)

	(method (doit)
		(AddToPic elements)
	)
)

(instance controls of Controls
	(properties
		name {controls}
	)
)

(instance timers of Set
	(properties
		name {timers}
	)
)

(instance aTOC of Code ; UNUSED
	(properties
		name {aTOC}
	)

	(method (doit param1 &tmp temp0 temp1 [temp2 48])
		(if (not (& (param1 signal:) $4000))
			(= temp0 (+ (gEgo xStep:) (/ (CelWide (gEgo view:) 2 0) 2)))
			(= temp1 (* (gEgo yStep:) 2))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						init:
							(- (param1 brLeft:) temp0)
							(- (CoordPri 1 (CoordPri (param1 y:))) temp1)
							(+ (param1 brRight:) temp0)
							(- (CoordPri 1 (CoordPri (param1 y:))) temp1)
							(+ (param1 brRight:) temp0)
							(+ (param1 y:) temp1)
							(- (param1 brLeft:) temp0)
							(+ (param1 y:) temp1)
						yourself:
					)
			)
		)
	)
)

(class Game of Obj
	(properties
		name {Game}
		script 0
		parseLang 1
		printLang 1
		subtitleLang 0
		_detailLevel 3
		panelObj 0
		panelSelector 0
	)

	(method (init)
		Motion
		Sound
		(ScriptID 932)
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSFeatures sFeatures) add:)
		((= gSounds Sounds) add:)
		((= gRegions regions) add:)
		((= gLocales locales) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		(= gFastCast 0)
		(= gCurSaveDir (GetSaveDir))
		(Inv init:)
		(if (not gUser)
			(= gUser User)
		)
		(gUser init:)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if panelObj
			(= temp1 panelObj)
			(= temp2 panelSelector)
			(= panelObj (= panelSelector 0))
			(Eval temp1 temp2)
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(if gFastCast
			(while gFastCast
				(gFastCast eachElementDo: 57)
				(if (and ((= temp0 (Event new:)) type:) gFastCast)
					(gFastCast firstTrue: 133 temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
			)
		)
		(if gPrints
			(gPrints eachElementDo: 57)
			(if (not gModelessDialog)
				(if (and ((= temp0 (Event new:)) type:) gPrints)
					(gPrints firstTrue: 133 temp0)
				)
				(temp0 dispose:)
				(= gGameTime (+ gTickOffset (GetTime)))
				(return)
			)
		)
		(gSounds eachElementDo: 174)
		(gTimers eachElementDo: 57)
		(if gModelessDialog
			(gModelessDialog check:)
		)
		(Animate (gCast elements:) 1)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(gCast eachElementDo: 243)
		)
		(if script
			(script doit:)
		)
		(gRegions eachElementDo: 57)
		(if (== gNewRoomNum gCurRoomNum)
			(gUser doit:)
		)
		(gTheDoits doit:)
		(if (!= gNewRoomNum gCurRoomNum)
			(self newRoom: gNewRoomNum)
		)
		(gTimers eachElementDo: 81)
		(GameIsRestarting 0)
	)

	(method (play)
		(= gGame self)
		(= gCurSaveDir (GetSaveDir))
		(if (not (GameIsRestarting))
			(GetCWD gCurSaveDir)
		)
		(self setCursor: gWaitCursor 1 init:)
		(self setCursor: gNormalCursor 1)
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (replay)
		(if gLastEvent
			(gLastEvent dispose:)
		)
		(gSFeatures release:)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gCast eachElementDo: 96 RU)
		(gGame setCursor: gWaitCursor 1)
		(DrawPic (gCurRoom curPic:) 100 1 global40)
		(if (!= gOverlays -1)
			(DrawPic gOverlays 100 0 global40)
		)
		(if (gCurRoom theControls:)
			((gCurRoom theControls:) draw:)
		)
		(gAddToPics doit:)
		(cond
			((not (User canControl:))
				(gGame setCursor: gWaitCursor)
			)
			((and gTheIconBar (gTheIconBar curIcon:))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(else
				(gGame setCursor: gNormalCursor)
			)
		)
		(HaveMouse)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= gTickOffset (- gGameTime (GetTime)))
		(while (not gQuit)
			(self doit:)
		)
	)

	(method (newRoom param1 &tmp [temp0 5] temp5)
		(gAddToPics eachElementDo: 111 eachElementDo: 81 release:)
		(gFeatures eachElementDo: 96 fDC release:)
		(gCast eachElementDo: 111 eachElementDo: 81)
		(gTimers eachElementDo: 81)
		(gRegions eachElementDo: 96 DNKR release:)
		(gLocales eachElementDo: 111 release:)
		(gTheDoits release:)
		(Animate 0)
		(= gPrevRoomNum gCurRoomNum)
		(= gCurRoomNum param1)
		(= gNewRoomNum param1)
		(FlushResources param1)
		(self startRoom: gCurRoomNum checkAni:)
		(SetSynonyms gRegions)
		(while ((= temp5 (Event new: 3)) type:)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)

	(method (startRoom param1)
		(if gDebugOn
			(SetDebug)
		)
		(gRegions addToFront: (= gCurRoom (ScriptID param1)))
		(gCurRoom init:)
	)

	(method (restart)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(RestartGame)
	)

	(method (restore &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 994 9 0 0 1 @temp23) ; "%s is not a valid directory."
			(Format @temp128 @temp23 gCurSaveDir)
			(Print font: 0 addText: @temp128 init:)
			(GetDirectory gCurSaveDir)
		)
		(= temp22 parseLang)
		(= parseLang 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(= temp21 (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= temp20 (Restore doit: &rest)) -1)
				(self setCursor: gWaitCursor 1)
				(if (CheckSaveGame name temp20 gVersion)
					(RestoreGame name temp20 gVersion)
				else
					(Message msgGET 994 3 0 0 1 @temp23) ; "That game was saved under a different interpreter. It cannot be restored."
					(Message msgGET 994 2 0 0 1 @temp123) ; "OK"
					(Print
						font: 0
						addText: @temp23
						addButton: 1 @temp123 0 40
						init:
					)
					(self setCursor: temp21 (HaveMouse))
					(= parseLang temp22)
				)
			else
				(= parseLang temp22)
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: 0)
	)

	(method (save &tmp [temp0 20] temp20 temp21 temp22 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath gCurSaveDir))
			(Message msgGET 994 9 0 0 1 @temp23) ; "%s is not a valid directory."
			(Format @temp128 @temp23 gCurSaveDir)
			(Print font: 0 addText: @temp128 init:)
			(GetDirectory gCurSaveDir)
		)
		(= temp22 parseLang)
		(= parseLang 1)
		(Load rsFONT gSmallFont)
		(ScriptID 990)
		(= temp21 (self setCursor: gNormalCursor))
		(Sound pause: 1)
		(if (PromptForDiskChange 1)
			(if gModelessDialog
				(gModelessDialog dispose:)
			)
			(if (!= (= temp20 (Save doit: @temp0)) -1)
				(= parseLang temp22)
				(= temp21 (self setCursor: gWaitCursor 1))
				(if (not (SaveGame name temp20 @temp0 gVersion))
					(Message msgGET 994 1 0 0 1 @temp23) ; "Your save game disk is full. You must either use another disk or save over an existing saved game."
					(Message msgGET 994 2 0 0 1 @temp123) ; "OK"
					(Print
						font: 0
						addText: @temp23
						addButton: 1 @temp123 0 40
						init:
					)
				)
				(self setCursor: temp21 (HaveMouse))
			)
			(PromptForDiskChange 0)
		)
		(Sound pause: 0)
		(= parseLang temp22)
	)

	(method (changeScore param1)
		(+= gScore param1)
		(SL doit:)
	)

	(method (handleEvent param1)
		(cond
			((param1 claimed:) 1)
			((and script (script handleEvent: param1)) 1)
			((& (param1 type:) $4000)
				(self pragmaFail:)
			)
		)
		(param1 claimed:)
	)

	(method (showMem &tmp [temp0 100])
		(Format
			@temp0
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1) ; FreeHeap
			(MemoryInfo 0) ; LargestPtr
			(>> (MemoryInfo miFREEHUNK) $0006)
			(MemoryInfo miLARGESTHUNK)
		)
		(Print addText: @temp0 init:)
	)

	(method (setSpeed param1 &tmp temp0)
		(= temp0 gSpeed)
		(= gSpeed param1)
		(return temp0)
	)

	(method (setCursor param1 param2 param3 param4 param5 param6 &tmp temp0)
		(= temp0 gTheCursor)
		(if (IsObject param1)
			(= gTheCursor param1)
			(param1 init:)
		else
			(SetCursor param1 0 0)
		)
		(if (> argc 1)
			(SetCursor param2)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor param1 0 0 param5 param6)
				)
			)
		)
		(return temp0)
	)

	(method (checkAni &tmp temp0)
		(Animate (gCast elements:) 0)
		(Wait 0)
		(Animate (gCast elements:) 0)
		(while (> (Wait 0) global30)
			(if (== (= temp0 (gCast firstTrue: 318)) 0)
				(break)
			)
			(temp0 addToPic:)
			(Animate (gCast elements:) 0)
			(gCast eachElementDo: 81)
		)
	)

	(method (notify))

	(method (setScript param1)
		(if script
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (quitGame param1)
		(if (or (not argc) param1)
			(= gQuit 1)
		)
	)

	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)

	(method (detailLevel param1)
		(if argc
			(= _detailLevel param1)
			(gCast eachElementDo: 319)
		)
		(return _detailLevel)
	)

	(method (pragmaFail))
)

(class Rgn of Obj
	(properties
		name {Rgn}
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
	)

	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script)
			(script dispose:)
		)
		(if (IsObject timer)
			(timer dispose: delete:)
		)
		(gSounds eachElementDo: 175 self)
		(DisposeScript number)
	)

	(method (handleEvent param1)
		(cond
			((param1 claimed:) 1)
			(
				(not
					(and
						script
						(or (script handleEvent: param1) 1)
						(param1 claimed:)
					)
				)
				(param1 claimed: (self doVerb: (param1 message:)))
			)
		)
		(param1 claimed:)
	)

	(method (doVerb param1 &tmp temp0)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (Message msgGET modNum noun param1 0 1)
			(gMessager say: noun param1 0 0 0 modNum)
		else
			(return 0)
		)
	)

	(method (setScript param1)
		(if (IsObject script)
			(script dispose:)
		)
		(if param1
			(param1 init: self &rest)
		)
	)

	(method (cue)
		(if script
			(script cue:)
		)
	)

	(method (newRoom))

	(method (notify))
)

(class Rm of Rgn
	(properties
		name {Rm}
		picture 0
		style -1
		horizon 0
		theControls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
	)

	(method (init &tmp temp0)
		(= number gCurRoomNum)
		(= theControls controls)
		(= gPerspective picAngle)
		(if picture
			(self drawPic: picture)
		)
		(self reflectPosn: (gUser alterEgo:) ((gUser alterEgo:) edgeHit:))
		((gUser alterEgo:) edgeHit: 0)
	)

	(method (doit &tmp temp0)
		(if script
			(script doit:)
		)
		(if (= temp0 (self edgeToRoom: ((gUser alterEgo:) edgeHit:)))
			(self newRoom: temp0)
		)
	)

	(method (dispose)
		(if theControls
			(theControls dispose:)
		)
		(if obstacles
			(obstacles dispose:)
		)
		(super dispose:)
	)

	(method (handleEvent param1)
		(cond
			(
				(or
					(and inset (inset handleEvent: param1))
					(super handleEvent: param1)
				))
			(theControls
				(theControls handleEvent: param1)
			)
		)
		(param1 claimed:)
	)

	(method (newRoom param1)
		(gRegions delete: self eachElementDo: 399 param1 addToFront: self)
		(= gNewRoomNum param1)
		(super newRoom: param1)
	)

	(method (setRegions param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			((= temp2 (ScriptID temp1)) number: temp1)
			(gRegions add: temp2)
			(if (not (temp2 initialized:))
				(temp2 init:)
			)
		)
	)

	(method (setFeatures param1 &tmp temp0 [temp1 2])
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(gFeatures add: [param1 temp0])
		)
	)

	(method (setLocales param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(= temp1 [param1 temp0])
			((= temp2 (ScriptID temp1)) number: temp1)
			(gLocales add: temp2)
			(temp2 init:)
		)
	)

	(method (drawPic param1 param2)
		(if gAddToPics
			(gAddToPics eachElementDo: 111 release:)
		)
		(= curPic param1)
		(= gOverlays -1)
		(DrawPic
			param1
			(cond
				((== argc 2) param2)
				((!= style -1) style)
				(else global17)
			)
			1
			global40
		)
	)

	(method (overlay param1 param2)
		(= gOverlays param1)
		(DrawPic
			param1
			(cond
				((== argc 2) param2)
				((!= style -1) style)
				(else global17)
			)
			0
			global40
		)
	)

	(method (addObstacle param1)
		(if (not (IsObject obstacles))
			(= obstacles (List new:))
		)
		(obstacles add: param1 &rest)
	)

	(method (reflectPosn param1 param2)
		(switch param2
			(1
				(param1 y: 188)
			)
			(4
				(param1 x: (- 319 (param1 xStep:)))
			)
			(3
				(param1 y: (+ horizon (param1 yStep:)))
			)
			(2
				(param1 x: 1)
			)
		)
	)

	(method (edgeToRoom param1)
		(return
			(switch param1
				(1 north)
				(2 east)
				(3 south)
				(4 west)
			)
		)
	)

	(method (roomToEdge param1)
		(return
			(switch param1
				(north 1)
				(south 3)
				(east 2)
				(west 4)
			)
		)
	)

	(method (setInset param1 param2 param3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)
)

(class Locale of Obj
	(properties
		name {Locale}
		number 0
	)

	(method (dispose)
		(gLocales delete: self)
		(DisposeScript number)
	)

	(method (handleEvent param1)
		(param1 claimed:)
	)
)

(class SL of Obj
	(properties
		name {SL}
		state 0
		code 0
	)

	(method (doit &tmp temp0)
		(if code
			(= temp0 (Memory memALLOC_CRIT (if 0 240 else 82)))
			(code doit: temp0)
			(DrawStatus (if state temp0 else 0))
			(Memory memFREE temp0)
		)
	)

	(method (enable)
		(= state 1)
		(self doit:)
	)

	(method (disable)
		(= state 0)
		(self doit:)
	)
)

(instance RU of Code
	(properties
		name {RU}
	)

	(method (doit param1 &tmp temp0)
		(if (param1 underBits:)
			(= temp0 (& (= temp0 (| (= temp0 (param1 signal:)) $0001)) $fffb))
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties
		name {DNKR}
	)

	(method (doit param1)
		(if (not (param1 keep:))
			(param1 dispose:)
		)
	)
)

(instance fDC of Code
	(properties
		name {fDC}
	)

	(method (doit param1)
		(if (param1 respondsTo: 81)
			(param1 signal: (& (param1 signal:) $ffdf) dispose: delete:)
		else
			(param1 dispose:)
		)
	)
)
