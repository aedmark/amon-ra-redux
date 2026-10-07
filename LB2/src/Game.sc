;;; Sierra Script 1.0 - (do not remove this comment)
(script# 994)
(include sci.sh)
(use Main)
(use Print)
(use DIcon)
(use Polygon)
(use Sound)
(use SRDialog)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(procedure (localproc_0ee1 param1 &tmp temp0 [temp1 40] [temp41 40] temp81 [temp82 40] [temp122 10] [temp132 5])
	(= temp81 (Memory memALLOC_CRIT (if 0 200 else 80)))
	(= temp0 1)
	(DeviceInfo 0 global29 @temp1)
	(DeviceInfo 1 @temp41)
	(if
		(and
			(DeviceInfo 3 @temp41)
			(or
				(DeviceInfo 2 @temp1 @temp41)
				(not (DeviceInfo 6 (gGame sel_20?)))
			)
		)
		(Message msgGET 994 6 0 0 1 @temp82)
		(Message msgGET 994 7 0 0 1 @temp122)
		(Message msgGET 994 8 0 0 1 @temp132)
		(Format
			temp81
			@temp82
			(if param1 @temp122 else @temp132)
			@temp1
		)
		(Load rsFONT gSel_30)
		(DeviceInfo 4)
		(Message msgGET 994 2 0 0 1 @temp82)
		(Message msgGET 994 4 0 0 1 @temp122)
		(Message msgGET 994 5 0 0 1 @temp132)
		(if
			(==
				(= temp0
					(if param1
						(Print
							sel_30: 0
							sel_198: temp81
							sel_205: 1 @temp82 0 40
							sel_205: 0 @temp122 30 40
							sel_205: 2 @temp132
							sel_110:
						)
					else
						(Print
							sel_30: 0
							sel_198: temp81
							sel_205: 1 @temp82 0 40
							sel_110:
						)
					)
				)
				2
			)
			(= temp0 (proc990_0 global29))
		)
	)
	(Memory memFREE temp81)
	(return temp0)
)

(instance cast of EventHandler
	(properties
		sel_20 {cast}
	)
)

(instance features of EventHandler
	(properties
		sel_20 {features}
	)
)

(instance theDoits of EventHandler
	(properties
		sel_20 {theDoits}
	)
)

(instance sFeatures of EventHandler
	(properties
		sel_20 {sFeatures}
	)
	
	(method (sel_81 param1)
		(super sel_81: param1)
		(if
			(and
				global34
				(param1 sel_114: Collect)
				(not (proc999_5 param1 gRegions gLocales))
			)
			(param1 sel_125: sel_111:)
		)
	)
)

(class Sounds of EventHandler
	(properties
		sel_20 {Sounds}
		sel_24 0
		sel_86 0
	)
	
	(method (sel_168 param1)
		(self sel_119: 96 mayPause (if argc param1 else 1))
	)
)

(instance mayPause of Code
	(properties
		sel_20 {mayPause}
	)
	
	(method (sel_57 param1 param2)
		(if (not (& (param1 sel_99?) $0001))
			(param1 sel_168: param2)
		)
	)
)

(instance regions of EventHandler
	(properties
		sel_20 {regions}
	)
)

(instance locales of EventHandler
	(properties
		sel_20 {locales}
	)
)

(instance addToPics of EventHandler
	(properties
		sel_20 {addToPics}
	)
	
	(method (sel_57)
		(AddToPic sel_24)
	)
)

(instance controls of Controls
	(properties
		sel_20 {controls}
	)
)

(instance timers of Set
	(properties
		sel_20 {timers}
	)
)

(instance aTOC of Code
	(properties
		sel_20 {aTOC}
	)
	
	(method (sel_57 param1 &tmp temp0 temp1 [temp2 48])
		(if (not (& (param1 sel_14?) $4000))
			(= temp0
				(+ (gEgo sel_51?) (/ (CelWide (gEgo sel_2?) 2 0) 2))
			)
			(= temp1 (* (gEgo sel_52?) 2))
			(global2
				sel_395:
					((Polygon sel_109:)
						sel_110:
							(- (param1 sel_17?) temp0)
							(- (CoordPri 1 (CoordPri (param1 sel_0?))) temp1)
							(+ (param1 sel_19?) temp0)
							(- (CoordPri 1 (CoordPri (param1 sel_0?))) temp1)
							(+ (param1 sel_19?) temp0)
							(+ (param1 sel_0?) temp1)
							(- (param1 sel_17?) temp0)
							(+ (param1 sel_0?) temp1)
						sel_117:
					)
			)
		)
	)
)

(class Game of Obj
	(properties
		sel_20 {Game}
		sel_142 0
		sel_83 1
		sel_84 1
		sel_85 0
		sel_396 3
		sel_397 0
		sel_398 0
	)
	
	(method (sel_110)
		Motion
		Sound
		(ScriptID 932)
		((= gSel_561 cast) sel_118:)
		((= gSel_562 features) sel_118:)
		((= gSFeatures sFeatures) sel_118:)
		((= gSounds Sounds) sel_118:)
		((= gRegions regions) sel_118:)
		((= gLocales locales) sel_118:)
		((= gSel_563 addToPics) sel_118:)
		((= gTimers timers) sel_118:)
		((= gTheDoits theDoits) sel_118:)
		(= gEventHandlerSel_109 0)
		(= global29 (GetSaveDir))
		(Inv sel_110:)
		(if (not gUser) (= gUser User))
		(gUser sel_110:)
	)
	
	(method (sel_57 &tmp eventSel_109 theSel_397 theSel_398)
		(if sel_397
			(= theSel_397 sel_397)
			(= theSel_398 sel_398)
			(= sel_397 (= sel_398 0))
			(proc999_7 theSel_397 theSel_398)
		)
		(= gSel_45 (+ global86 (GetTime)))
		(if gEventHandlerSel_109
			(while gEventHandlerSel_109
				(gEventHandlerSel_109 sel_119: 57)
				(if
					(and
						((= eventSel_109 (Event sel_109:)) sel_31?)
						gEventHandlerSel_109
					)
					(gEventHandlerSel_109 sel_120: 133 eventSel_109)
				)
				(eventSel_109 sel_111:)
				(= gSel_45 (+ global86 (GetTime)))
			)
		)
		(if global92
			(global92 sel_119: 57)
			(if (not gSel_201)
				(if
					(and
						((= eventSel_109 (Event sel_109:)) sel_31?)
						global92
					)
					(global92 sel_120: 133 eventSel_109)
				)
				(eventSel_109 sel_111:)
				(= gSel_45 (+ global86 (GetTime)))
				(return)
			)
		)
		(gSounds sel_119: 174)
		(gTimers sel_119: 57)
		(if gSel_201 (gSel_201 sel_174:))
		(Animate (gSel_561 sel_24?) 1)
		(if global37 (= global37 0) (gSel_561 sel_119: 243))
		(if sel_142 (sel_142 sel_57:))
		(gRegions sel_119: 57)
		(if (== gTheGSel_40 gSel_40) (gUser sel_57:))
		(gTheDoits sel_57:)
		(if (!= gTheGSel_40 gSel_40)
			(self sel_399: gTheGSel_40)
		)
		(gTimers sel_119: 81)
		(GameIsRestarting 0)
	)
	
	(method (sel_39)
		(= gGame self)
		(= global29 (GetSaveDir))
		(if (not (GameIsRestarting)) (GetCWD global29))
		(self sel_197: global21 1 sel_110:)
		(self sel_197: gWalkCursor 1)
		(while (not global4)
			(self sel_57:)
		)
	)
	
	(method (sel_62)
		(if global24 (global24 sel_111:))
		(gSFeatures sel_125:)
		(if gSel_201 (gSel_201 sel_111:))
		(gSel_561 sel_119: 96 RU)
		(gGame sel_197: global21 1)
		(DrawPic
			(global2 sel_405?)
			dpOPEN_NO_TRANSITION
			dpCLEAR
			global40
		)
		(if (!= global36 -1)
			(DrawPic
				global36
				dpOPEN_NO_TRANSITION
				dpNO_CLEAR
				global40
			)
		)
		(if (global2 sel_343?) ((global2 sel_343?) sel_80:))
		(gSel_563 sel_57:)
		(cond 
			((not (User sel_237:)) (gGame sel_197: global21))
			((and gIconBar (gIconBar sel_207?)) (gGame sel_197: ((gIconBar sel_207?) sel_33?)))
			(else (gGame sel_197: gWalkCursor))
		)
		(HaveMouse)
		(SL sel_57:)
		(DoSound sndRESTORE)
		(Sound sel_168: 0)
		(= global86 (- gSel_45 (GetTime)))
		(while (not global4)
			(self sel_57:)
		)
	)
	
	(method (sel_399 theGSel_40 &tmp [temp0 5] temp5)
		(gSel_563 sel_119: 111 sel_119: 81 sel_125:)
		(gSel_562 sel_119: 96 fDC sel_125:)
		(gSel_561 sel_119: 111 sel_119: 81)
		(gTimers sel_119: 81)
		(gRegions sel_119: 96 DNKR sel_125:)
		(gLocales sel_119: 111 sel_125:)
		(gTheDoits sel_125:)
		(Animate 0)
		(= gGSel_40 gSel_40)
		(= gSel_40 theGSel_40)
		(= gTheGSel_40 theGSel_40)
		(FlushResources theGSel_40)
		(self sel_400: gSel_40 sel_402:)
		(SetSynonyms gRegions)
		(while ((= temp5 (Event sel_109: 3)) sel_31?)
			(temp5 sel_111:)
		)
		(temp5 sel_111:)
	)
	
	(method (sel_400 param1)
		(if global14 (SetDebug))
		(gRegions sel_129: (= global2 (ScriptID param1)))
		(global2 sel_110:)
	)
	
	(method (sel_101)
		(if gSel_201 (gSel_201 sel_111:))
		(RestartGame)
	)
	
	(method (sel_76 &tmp [temp0 20] temp20 temp21 theSel_83 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath global29))
			(Message msgGET 994 9 0 0 1 @temp23)
			(Format @temp128 @temp23 global29)
			(Print sel_30: 0 sel_198: @temp128 sel_110:)
			(proc990_0 global29)
		)
		(= theSel_83 sel_83)
		(= sel_83 1)
		(Load rsFONT global23)
		(ScriptID 990)
		(= temp21 (self sel_197: gWalkCursor))
		(Sound sel_168: 1)
		(if (localproc_0ee1 1)
			(if gSel_201 (gSel_201 sel_111:))
			(if (!= (= temp20 (Restore sel_57: &rest)) -1)
				(self sel_197: global21 1)
				(if (CheckSaveGame sel_20 temp20 global27)
					(RestoreGame sel_20 temp20 global27)
				else
					(Message msgGET 994 3 0 0 1 @temp23)
					(Message msgGET 994 2 0 0 1 @temp123)
					(Print
						sel_30: 0
						sel_198: @temp23
						sel_205: 1 @temp123 0 40
						sel_110:
					)
					(self sel_197: temp21 (HaveMouse))
					(= sel_83 theSel_83)
				)
			else
				(= sel_83 theSel_83)
			)
			(localproc_0ee1 0)
		)
		(Sound sel_168: 0)
	)
	
	(method (sel_75 &tmp [temp0 20] temp20 temp21 theSel_83 [temp23 100] [temp123 5] [temp128 100])
		(if (not (ValidPath global29))
			(Message msgGET 994 9 0 0 1 @temp23)
			(Format @temp128 @temp23 global29)
			(Print sel_30: 0 sel_198: @temp128 sel_110:)
			(proc990_0 global29)
		)
		(= theSel_83 sel_83)
		(= sel_83 1)
		(Load rsFONT global23)
		(ScriptID 990)
		(= temp21 (self sel_197: gWalkCursor))
		(Sound sel_168: 1)
		(if (localproc_0ee1 1)
			(if gSel_201 (gSel_201 sel_111:))
			(if (!= (= temp20 (Save sel_57: @temp0)) -1)
				(= sel_83 theSel_83)
				(= temp21 (self sel_197: global21 1))
				(if (not (SaveGame sel_20 temp20 @temp0 global27))
					(Message msgGET 994 1 0 0 1 @temp23)
					(Message msgGET 994 2 0 0 1 @temp123)
					(Print
						sel_30: 0
						sel_198: @temp23
						sel_205: 1 @temp123 0 40
						sel_110:
					)
				)
				(self sel_197: temp21 (HaveMouse))
			)
			(localproc_0ee1 0)
		)
		(Sound sel_168: 0)
		(= sel_83 theSel_83)
	)
	
	(method (sel_388 param1)
		(= global15 (+ global15 param1))
		(SL sel_57:)
	)
	
	(method (sel_133 param1)
		(cond 
			((param1 sel_73?) 1)
			((and sel_142 (sel_142 sel_133: param1)) 1)
			((& (param1 sel_31?) $4000) (self sel_71:))
		)
		(param1 sel_73?)
	)
	
	(method (sel_401 &tmp [temp0 100])
		(Format
			@temp0
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1)
			(MemoryInfo 0)
			(>> (MemoryInfo 3) $0006)
			(MemoryInfo 2)
		)
		(Print sel_198: @temp0 sel_110:)
	)
	
	(method (sel_352 param1 &tmp temp0)
		(= temp0 global3)
		(= global3 param1)
		(return temp0)
	)
	
	(method (sel_197 theGSel_582_2 param2 param3 param4 param5 param6 &tmp theGSel_582)
		(= theGSel_582 gSel_582)
		(if (IsObject theGSel_582_2)
			(= gSel_582 theGSel_582_2)
			(theGSel_582_2 sel_110:)
		else
			(SetCursor theGSel_582_2 0 0)
		)
		(if (> argc 1)
			(SetCursor param2)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor theGSel_582_2 0 0 param5 param6)
				)
			)
		)
		(return theGSel_582)
	)
	
	(method (sel_402 &tmp temp0)
		(Animate (gSel_561 sel_24?) 0)
		(Wait 0)
		(Animate (gSel_561 sel_24?) 0)
		(while (> (Wait 0) global30)
			(breakif (== (= temp0 (gSel_561 sel_120: 318)) 0))
			(temp0 sel_317:)
			(Animate (gSel_561 sel_24?) 0)
			(gSel_561 sel_119: 81)
		)
	)
	
	(method (sel_403)
	)
	
	(method (sel_146 param1)
		(if sel_142 (sel_142 sel_111:))
		(if param1 (param1 sel_110: self &rest))
	)
	
	(method (sel_145)
		(if sel_142 (sel_142 sel_145:))
	)
	
	(method (sel_100 param1)
		(if (or (not argc) param1) (= global4 1))
	)
	
	(method (sel_404 param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)
	
	(method (sel_321 theSel_396)
		(if argc (= sel_396 theSel_396) (gSel_561 sel_119: 319))
		(return sel_396)
	)
	
	(method (sel_71)
	)
)

(class Rgn of Obj
	(properties
		sel_20 {Rgn}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
	)
	
	(method (sel_110)
		(if (not sel_407)
			(= sel_407 1)
			(if (not (gRegions sel_122: self))
				(gRegions sel_130: self)
			)
			(super sel_110:)
		)
	)
	
	(method (sel_57)
		(if sel_142 (sel_142 sel_57:))
	)
	
	(method (sel_111)
		(gRegions sel_81: self)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if (IsObject sel_135) (sel_135 sel_111: sel_81:))
		(gSounds sel_119: 175 self)
		(DisposeScript sel_40)
	)
	
	(method (sel_133 param1)
		(cond 
			((param1 sel_73?) 1)
			(
				(not
					(if (and sel_142 (or (sel_142 sel_133: param1) 1))
						(param1 sel_73?)
					)
				)
				(param1 sel_73: (self sel_300: (param1 sel_37?)))
			)
		)
		(param1 sel_73?)
	)
	
	(method (sel_300 param1 &tmp temp0)
		(if (== sel_214 -1) (= sel_214 gSel_40))
		(return
			(if (Message msgGET sel_214 sel_213 param1 0 1)
				(gLb2Messager sel_295: sel_213 param1 0 0 0 sel_214)
			else
				(return 0)
			)
		)
	)
	
	(method (sel_146 param1)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if param1 (param1 sel_110: self &rest))
	)
	
	(method (sel_145)
		(if sel_142 (sel_142 sel_145:))
	)
	
	(method (sel_399)
	)
	
	(method (sel_403)
	)
)

(class Rm of Rgn
	(properties
		sel_20 {Rm}
		sel_142 0
		sel_40 0
		sel_214 -1
		sel_213 0
		sel_135 0
		sel_406 0
		sel_407 0
		sel_408 0
		sel_28 -1
		sel_340 0
		sel_343 0
		sel_409 0
		sel_410 0
		sel_411 0
		sel_412 0
		sel_405 0
		sel_413 0
		sel_107 160
		sel_108 0
		sel_259 0
		sel_365 0
	)
	
	(method (sel_110 &tmp temp0)
		(= sel_40 gSel_40)
		(= sel_343 controls)
		(= gSel_413 sel_413)
		(if sel_408 (self sel_417: sel_408))
		(self
			sel_419: (gUser sel_341?) ((gUser sel_341?) sel_349?)
		)
		((gUser sel_341?) sel_349: 0)
	)
	
	(method (sel_57 &tmp temp0)
		(if sel_142 (sel_142 sel_57:))
		(if
		(= temp0 (self sel_420: ((gUser sel_341?) sel_349?)))
			(self sel_399: temp0)
		)
	)
	
	(method (sel_111)
		(if sel_343 (sel_343 sel_111:))
		(if sel_259 (sel_259 sel_111:))
		(super sel_111:)
	)
	
	(method (sel_133 param1)
		(cond 
			(
				(or
					(and sel_365 (sel_365 sel_133: param1))
					(super sel_133: param1)
				)
			)
			(sel_343 (sel_343 sel_133: param1))
		)
		(param1 sel_73?)
	)
	
	(method (sel_399 theGTheGSel_40)
		(gRegions
			sel_81: self
			sel_119: 399 theGTheGSel_40
			sel_129: self
		)
		(= gTheGSel_40 theGTheGSel_40)
		(super sel_399: theGTheGSel_40)
	)
	
	(method (sel_414 param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= temp1 [param1 temp0])
			((= temp2 (ScriptID temp1)) sel_40: temp1)
			(gRegions sel_118: temp2)
			(if (not (temp2 sel_407?)) (temp2 sel_110:))
			(++ temp0)
		)
	)
	
	(method (sel_415 param1 &tmp temp0 [temp1 2])
		(= temp0 0)
		(while (< temp0 argc)
			(gSel_562 sel_118: [param1 temp0])
			(++ temp0)
		)
	)
	
	(method (sel_416 param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= temp1 [param1 temp0])
			((= temp2 (ScriptID temp1)) sel_40: temp1)
			(gLocales sel_118: temp2)
			(temp2 sel_110:)
			(++ temp0)
		)
	)
	
	(method (sel_417 theSel_405 param2)
		(if gSel_563 (gSel_563 sel_119: 111 sel_125:))
		(= sel_405 theSel_405)
		(= global36 -1)
		(DrawPic
			theSel_405
			(cond 
				((== argc 2) param2)
				((!= sel_28 -1) sel_28)
				(else global17)
			)
			dpCLEAR
			global40
		)
	)
	
	(method (sel_418 param1 param2)
		(= global36 param1)
		(DrawPic
			param1
			(cond 
				((== argc 2) param2)
				((!= sel_28 -1) sel_28)
				(else global17)
			)
			dpNO_CLEAR
			global40
		)
	)
	
	(method (sel_395 param1)
		(if (not (IsObject sel_259))
			(= sel_259 (List sel_109:))
		)
		(sel_259 sel_118: param1 &rest)
	)
	
	(method (sel_419 param1 param2)
		(switch param2
			(1 (param1 sel_0: 188))
			(4
				(param1 sel_1: (- 319 (param1 sel_51?)))
			)
			(3
				(param1 sel_0: (+ sel_340 (param1 sel_52?)))
			)
			(2 (param1 sel_1: 1))
		)
	)
	
	(method (sel_420 param1)
		(switch param1
			(1 sel_409)
			(2 sel_410)
			(3 sel_411)
			(4 sel_412)
		)
	)
	
	(method (sel_421 param1)
		(switch param1
			(sel_409 1)
			(sel_411 3)
			(sel_410 2)
			(sel_412 4)
		)
	)
	
	(method (sel_422 param1 param2 param3)
		(if sel_365 (sel_365 sel_111:))
		(if (and argc param1)
			(param1
				sel_110:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)
)

(class Locale of Obj
	(properties
		sel_20 {Locale}
		sel_40 0
	)
	
	(method (sel_111)
		(gLocales sel_81: self)
		(DisposeScript sel_40)
	)
	
	(method (sel_133 param1)
		(param1 sel_73?)
	)
)

(class SL of Obj
	(properties
		sel_20 {SL}
		sel_29 0
		sel_328 0
	)
	
	(method (sel_57 &tmp temp0)
		(if sel_328
			(= temp0 (Memory memALLOC_CRIT (if 0 240 else 82)))
			(sel_328 sel_57: temp0)
			(DrawStatus (if sel_29 temp0 else 0))
			(Memory memFREE temp0)
		)
	)
	
	(method (sel_177)
		(= sel_29 1)
		(self sel_57:)
	)
	
	(method (sel_233)
		(= sel_29 0)
		(self sel_57:)
	)
)

(instance RU of Code
	(properties
		sel_20 {RU}
	)
	
	(method (sel_57 param1 &tmp temp0)
		(if (param1 sel_5?)
			(= temp0
				(&
					(= temp0 (| (= temp0 (param1 sel_14?)) $0001))
					$fffb
				)
			)
			(param1 sel_5: 0 sel_14: temp0)
		)
	)
)

(instance DNKR of Code
	(properties
		sel_20 {DNKR}
	)
	
	(method (sel_57 param1)
		(if (not (param1 sel_406?)) (param1 sel_111:))
	)
)

(instance fDC of Code
	(properties
		sel_20 {fDC}
	)
	
	(method (sel_57 param1)
		(if (param1 sel_116: 81)
			(param1
				sel_14: (& (param1 sel_14?) $ffdf)
				sel_111:
				sel_81:
			)
		else
			(param1 sel_111:)
		)
	)
)
