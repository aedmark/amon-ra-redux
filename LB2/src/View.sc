;;; Sierra Script 1.0 - (do not remove this comment)
(script# 998)
(include sci.sh)
(define sel_4103 4103)
(use Main)
(use Print)
(use PolyPath)
(use CueObj)
(use Cycle)
(use Obj)


(class View of Feature
	(properties
		sel_20 {View}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 257
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
	)
	
	(method (sel_110 &tmp temp0)
		(= temp0 (if (& sel_14 $0020) gSel_563 else gSel_561))
		(= sel_14 (& sel_14 $7fff))
		(if (not (temp0 sel_122: self))
			(= sel_13 (= sel_12 (= sel_11 (= sel_10 0))))
			(= sel_14 (& sel_14 $ff77))
		)
		(BaseSetter self)
		(temp0 sel_118: self)
		(if (== temp0 gSel_563)
			(if (not (& sel_14 $0010))
				(= sel_60 (CoordPri sel_0))
			)
			(SetNowSeen self)
			(temp0 sel_57:)
		)
		(self sel_307: sel_319:)
	)
	
	(method (sel_111)
		(self sel_315: sel_102:)
		(= sel_14 (| sel_14 $8000))
	)
	
	(method (sel_113)
		(Print
			sel_198: sel_20
			sel_206: sel_2 sel_3 sel_4
			sel_110:
		)
	)
	
	(method (sel_310)
		(return (not (& sel_14 $0088)))
	)
	
	(method (sel_218 param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 sel_1?))
			(= temp1 (param1 sel_0?))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(cond 
			((& sel_14 $0080) 0)
			(
			(and (not (IsObject sel_302)) (& sel_14 $1000))
				(if
					(or
						(not (if (or sel_7 sel_9 sel_6) else sel_8))
						(and
							(<= sel_7 temp0)
							(<= temp0 sel_9)
							(<= sel_6 temp1)
							(<= temp1 sel_8)
						)
					)
					(not
						(IsItSkip
							sel_2
							sel_3
							sel_4
							(- temp1 sel_6)
							(- temp0 sel_7)
						)
					)
				)
			)
			(else (super sel_218: temp0 temp1))
		)
	)
	
	(method (sel_153 theSel_1 theSel_0 theSel_82)
		(if (>= argc 1)
			(= sel_1 theSel_1)
			(if (>= argc 2)
				(= sel_0 theSel_0)
				(if (>= argc 3) (= sel_82 theSel_82))
			)
		)
		(BaseSetter self)
		(self sel_314:)
	)
	
	(method (sel_313)
		(= sel_14 (| sel_14 $0001))
		(= sel_14 (& sel_14 $fffd))
	)
	
	(method (sel_314)
		(= sel_14 (| sel_14 $0040))
	)
	
	(method (sel_315)
		(= sel_14 (| sel_14 $0002))
		(= sel_14 (& sel_14 $fffe))
	)
	
	(method (sel_63 theSel_60)
		(cond 
			((== argc 0) (= sel_14 (| sel_14 $0010)))
			((== theSel_60 -1) (= sel_14 (& sel_14 $ffef)))
			(else (= sel_60 theSel_60) (= sel_14 (| sel_14 $0010)))
		)
		(self sel_314:)
	)
	
	(method (sel_155 theSel_3)
		(cond 
			((== argc 0) (= sel_14 (| sel_14 $0800)))
			((== theSel_3 -1) (= sel_14 (& sel_14 $f7ff)))
			(else (= sel_3 theSel_3) (= sel_14 (| sel_14 $0800)))
		)
		(self sel_314:)
	)
	
	(method (sel_156 param1)
		(cond 
			((== argc 0) 0)
			((== param1 -1) 0)
			(else
				(= sel_4
					(if (>= param1 (self sel_246:))
						(self sel_246:)
					else
						param1
					)
				)
			)
		)
		(self sel_314:)
	)
	
	(method (sel_316 param1)
		(if (or (== 0 argc) param1)
			(= sel_14 (| sel_14 $4000))
		else
			(= sel_14 (& sel_14 $bfff))
		)
	)
	
	(method (sel_102)
		(= sel_14 (| sel_14 $0008))
	)
	
	(method (sel_216)
		(= sel_14 (& sel_14 $fff7))
	)
	
	(method (sel_81)
		(if (& sel_14 $8000)
			(= sel_14 (& sel_14 $7fff))
			(cond 
				((gSel_563 sel_122: self) (gSel_563 sel_81: self) (= sel_14 (& sel_14 $ffdf)))
				((& sel_14 $0020) (gSel_561 sel_81: self) (gSel_563 sel_118: self) (return))
				(else (gSel_561 sel_81: self))
			)
			(if sel_5 (UnLoad 133 sel_5) (= sel_5 0))
			(super sel_111:)
			(if (IsObject sel_299) (sel_299 sel_111:))
			(= sel_299 0)
		)
	)
	
	(method (sel_317)
		(if (gSel_561 sel_122: self)
			(= sel_14 (| sel_14 $8021))
		else
			(= sel_14 (| sel_14 $0020))
			(self sel_110:)
		)
	)
	
	(method (sel_246)
		(return (- (NumCels self) 1))
	)
	
	(method (sel_318 param1 &tmp temp0)
		(= temp0 (& sel_14 $0200))
		(if argc
			(if param1
				(= sel_14 (| sel_14 $0200))
			else
				(= sel_14 (& sel_14 $fdff))
			)
		)
		(return temp0)
	)
	
	(method (sel_243)
	)
	
	(method (sel_319)
	)
	
	(method (sel_320 param1 &tmp temp0 temp1 temp2 [temp3 40])
		(cond 
			((not argc) (= sel_103 1))
			((not param1) (= sel_103 0))
			((< param1 (global2 sel_108?))
				(proc921_1
					@temp3
					{<%s setScale:> y value less than vanishingY}
					sel_20
				)
			)
			(else
				(= temp0 (- param1 (global2 sel_108?)))
				(= temp2
					(+ (/ (* (= temp1 (- 190 param1)) 100) temp0) 100)
				)
				(= sel_103 (| sel_103 $0003))
				(= sel_106 (/ (* temp2 128) 100))
			)
		)
	)
)

(class Prop of View
	(properties
		sel_20 {Prop}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 0
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
		sel_244 6
		sel_142 0
		sel_245 0
		sel_135 0
		sel_321 0
		sel_322 0
	)
	
	(method (sel_57 &tmp temp0)
		(SetNowSeen self sel_6)
		(if (& sel_14 $8000) (return))
		(if sel_142 (sel_142 sel_57:))
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_245 (sel_245 sel_57:))
		(if sel_322 (sel_322 sel_57:))
	)
	
	(method (sel_133 param1)
		(if sel_142 (sel_142 sel_133: param1))
		(super sel_133: param1)
	)
	
	(method (sel_81)
		(if (& sel_14 $8000)
			(self sel_146: 0 sel_161: 0)
			(if sel_135 (sel_135 sel_111:))
			(if (IsObject sel_322)
				(sel_322 sel_111:)
				(= sel_322 0)
			)
			(super sel_81:)
		)
	)
	
	(method (sel_243)
		(if (and sel_245 (sel_245 sel_240?))
			(sel_245 sel_243:)
		)
	)
	
	(method (sel_319 param1)
		(cond 
			((not sel_321))
			(
			(< (if argc param1 else (gGame sel_321:)) sel_321) (self sel_313:))
			(sel_245 (self sel_315:))
		)
	)
	
	(method (sel_320 param1 param2 &tmp [temp0 40])
		(if sel_322 (sel_322 sel_111:) (= sel_322 0))
		(cond 
			((not argc) (= sel_103 1))
			((IsObject param1)
				(= sel_103 1)
				(= sel_322
					(if (& (param1 sel_4103?) $8000)
						(param1 sel_109:)
					else
						param1
					)
				)
				(sel_322 sel_110: self param2 &rest)
			)
			((== param1 -1)
				(if (param2 sel_103?)
					(= sel_103 (param2 sel_103?))
					(= sel_106 (param2 sel_106?))
					(if (IsObject (param2 sel_322?))
						((= sel_322 ((param2 sel_322?) sel_109:)) sel_42: self)
					)
				)
			)
			(else (super sel_320: param1))
		)
	)
	
	(method (sel_161 param1)
		(if sel_245 (sel_245 sel_111:))
		(if param1
			(self sel_315:)
			(= sel_245
				(if (& (param1 sel_4103?) $8000)
					(param1 sel_109:)
				else
					param1
				)
			)
			(sel_245 sel_110: self &rest)
		else
			(= sel_245 0)
		)
	)
	
	(method (sel_146 param1)
		(if (IsObject sel_142) (sel_142 sel_111:))
		(if param1 (param1 sel_110: self &rest))
	)
	
	(method (sel_145)
		(if sel_142 (sel_142 sel_145:))
	)
)

(class Actor of Prop
	(properties
		sel_20 {Actor}
		sel_1 0
		sel_0 0
		sel_82 0
		sel_55 0
		sel_213 0
		sel_214 -1
		sel_6 0
		sel_7 0
		sel_8 0
		sel_9 0
		sel_301 26505
		sel_299 0
		sel_302 26505
		sel_303 0
		sel_304 0
		sel_305 0
		sel_306 0
		sel_52 2
		sel_2 -1
		sel_3 0
		sel_4 0
		sel_60 0
		sel_5 0
		sel_14 0
		sel_10 0
		sel_11 0
		sel_12 0
		sel_13 0
		sel_16 0
		sel_17 0
		sel_18 0
		sel_19 0
		sel_88 0
		sel_103 0
		sel_104 128
		sel_105 128
		sel_106 128
		sel_244 6
		sel_142 0
		sel_245 0
		sel_135 0
		sel_321 0
		sel_322 0
		sel_15 -32768
		sel_249 0
		sel_250 0
		sel_51 3
		sel_323 770
		sel_53 6
		sel_324 0
		sel_325 0
		sel_56 0
		sel_59 0
		sel_326 0
		sel_327 0
		sel_328 0
	)
	
	(method (sel_110)
		(super sel_110: &rest)
		(= sel_249 sel_1)
		(= sel_250 sel_0)
	)
	
	(method (sel_57 &tmp temp0 theSel_17 theSel_19 temp3 temp4 temp5 temp6)
		(if (& sel_14 $8000) (return))
		(if sel_142 (sel_142 sel_57:))
		(if sel_328 (sel_328 sel_57: self))
		(if (and (& sel_14 $0004) (not (& sel_14 $0002)))
			(return)
		)
		(if sel_326 (sel_326 sel_57: self))
		(cond 
			(sel_327 (sel_327 sel_57:))
			(sel_56
				(sel_56 sel_57:)
				(if (& sel_103 $0001)
					(= temp5 (>> sel_323 $0008))
					(= temp6 (& sel_323 $00ff))
					(= temp3 (/ (+ (/ (* temp5 sel_104 10) 128) 5) 10))
					(= temp4 (/ (+ (/ (* temp6 sel_105 10) 128) 5) 10))
					(if (or (!= temp3 sel_51) (!= temp4 sel_52))
						(if (< temp3 1) (= temp3 1))
						(if (< temp4 1) (= temp4 1))
						(self sel_338: temp3 temp4 1)
					)
				)
			)
		)
		(if sel_322 (sel_322 sel_57:))
		(if sel_245
			(= theSel_17 sel_17)
			(= theSel_19 sel_19)
			(sel_245 sel_57:)
			(if sel_325
				(sel_325 sel_57: self)
			else
				(BaseSetter self)
			)
			(if
				(and
					(or (!= theSel_17 sel_17) (!= theSel_19 sel_19))
					(self sel_54:)
				)
				(self sel_335:)
			)
		)
		(= sel_249 sel_1)
		(= sel_250 sel_0)
	)
	
	(method (sel_153 theSel_249 theSel_250)
		(super sel_153: theSel_249 theSel_250 &rest)
		(= sel_249 theSel_249)
		(= sel_250 theSel_250)
		(if (self sel_54:) (self sel_335:))
	)
	
	(method (sel_155 param1 &tmp theSel_59)
		(if
			(= theSel_59
				(cond 
					((== argc 0) (super sel_155:) 0)
					((not (IsObject param1)) (super sel_155: param1 &rest) 0)
					((& (param1 sel_4103?) $8000) (param1 sel_109:))
					(else param1)
				)
			)
			(if sel_59 (sel_59 sel_111:))
			((= sel_59 theSel_59) sel_110: self &rest)
		)
	)
	
	(method (sel_81)
		(if (& sel_14 $8000)
			(if (!= sel_56 -1) (self sel_312: 0))
			(self sel_329: 0)
			(if sel_325 (sel_325 sel_111:) (= sel_325 0))
			(if sel_59 (sel_59 sel_111:) (= sel_59 0))
			(if sel_326 (sel_326 sel_111:) (= sel_326 0))
			(if sel_324 (sel_324 sel_111:) (= sel_324 0))
			(if sel_328 (sel_328 sel_111:) (= sel_328 0))
			(if (IsObject sel_299)
				(sel_299 sel_111:)
				(= sel_299 0)
			)
			(super sel_81:)
		)
	)
	
	(method (sel_243)
		(if (and sel_56 (sel_56 sel_240?)) (sel_56 sel_243:))
		(super sel_243:)
	)
	
	(method (sel_319 param1)
		(cond 
			((not sel_321))
			(
			(< (if argc param1 else (gGame sel_321:)) sel_321) (self sel_313:))
			((or sel_245 sel_56) (self sel_315:))
		)
	)
	
	(method (sel_312 param1)
		(if (and sel_56 (!= sel_56 -1)) (sel_56 sel_111:))
		(if param1
			(self sel_315:)
			(= sel_56
				(if (& (param1 sel_4103?) $8000)
					(param1 sel_109:)
				else
					param1
				)
			)
			(sel_56 sel_110: self &rest)
		else
			(= sel_56 0)
		)
	)
	
	(method (sel_329 param1)
		(if sel_327 (sel_327 sel_111:))
		(= sel_327
			(if
			(and (IsObject param1) (& (param1 sel_4103?) $8000))
				(param1 sel_109:)
			else
				param1
			)
		)
		(if sel_327 (sel_327 sel_110: self &rest))
	)
	
	(method (sel_330 param1)
		(if (or (not argc) param1)
			(= sel_14 (| sel_14 $2000))
		else
			(= sel_14 (& sel_14 $dfff))
		)
	)
	
	(method (sel_331 param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			(= sel_15 (| sel_15 [param1 temp0]))
			(++ temp0)
		)
	)
	
	(method (sel_332 param1 &tmp temp0)
		(= temp0 0)
		(while (< temp0 argc)
			(= sel_15 (& sel_15 (~ [param1 temp0])))
			(++ temp0)
		)
	)
	
	(method (sel_333)
		(if (not sel_324) (= sel_324 (Set sel_109:)))
		(sel_324 sel_118: &rest)
	)
	
	(method (sel_334)
		(sel_324 sel_81: &rest)
		(if (sel_324 sel_123:)
			(sel_324 sel_111:)
			(= sel_324 0)
		)
	)
	
	(method (sel_247)
		(return
			(cond 
				((not (IsObject sel_56)))
				((== sel_1 (sel_56 sel_249?)) (== sel_0 (sel_56 sel_250?)))
			)
		)
	)
	
	(method (sel_58)
		(return (& sel_14 $0400))
	)
	
	(method (sel_335 &tmp [temp0 5])
	)
	
	(method (sel_336 param1 param2 param3 param4)
		(return
			(if
				(and
					(<= param1 sel_1)
					(< sel_1 param3)
					(<= param2 sel_0)
				)
				(< sel_0 param4)
			else
				0
			)
		)
	)
	
	(method (sel_337 param1)
		(if (and argc param1)
			(OnControl 4 sel_1 sel_0)
		else
			(OnControl 4 sel_17 sel_16 sel_19 sel_18)
		)
	)
	
	(method (sel_255 param1)
		(GetDistance
			sel_1
			sel_0
			(param1 sel_1?)
			(param1 sel_0?)
			gSel_413
		)
	)
	
	(method (sel_54 &tmp temp0)
		(if sel_325
			(sel_325 sel_57: self)
		else
			(BaseSetter self)
		)
		(= temp0
			(cond 
				((CantBeHere self (gSel_561 sel_24?)))
				(
					(and
						(not (& sel_14 $2000))
						(IsObject global2)
						(< sel_0 (global2 sel_340?))
					)
					-1
				)
				((and sel_324 (not (sel_324 sel_121: 57 self))) -2)
			)
		)
	)
	
	(method (sel_338 theTheSel_51 theTheSel_52 param3 &tmp theSel_51 theSel_52)
		(= theSel_51 (>> sel_323 $0008))
		(= theSel_52 (& sel_323 $00ff))
		(if (and (>= argc 1) (!= theTheSel_51 -1))
			(= theSel_51 theTheSel_51)
		)
		(if (and (>= argc 2) (!= theTheSel_52 -1))
			(= theSel_52 theTheSel_52)
		)
		(if (or (< argc 3) (not param3))
			(= sel_323 (+ (<< theSel_51 $0008) theSel_52))
		)
		(= sel_51 theSel_51)
		(= sel_52 theSel_52)
		(if
			(and
				(IsObject sel_56)
				(or (sel_56 sel_115: MoveTo) (sel_56 sel_115: PolyPath))
			)
			(sel_56 sel_110:)
		)
	)
	
	(method (sel_339 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp0
			(if (== (= temp1 (global2 sel_108?)) -30000)
				sel_1
			else
				(global2 sel_107?)
			)
		)
		(if (and (== sel_51 0) (== sel_52 0)) (return))
		(= temp5 (/ 32000 (proc999_3 sel_51 sel_52)))
		(switch param1
			(0 (self sel_312: 0) (return))
			(1
				(= temp2 (- temp0 sel_1))
				(= temp3 (- temp1 sel_0))
			)
			(5
				(= temp2 (- sel_1 temp0))
				(= temp3 (- sel_0 temp1))
			)
			(3 (= temp2 temp5) (= temp3 0))
			(7
				(= temp2 (- temp5))
				(= temp3 0)
			)
			(else 
				(if
				(< 180 (= temp4 (GetAngle sel_1 sel_0 temp0 temp1)))
					(= temp4 (- temp4 360))
				)
				(= temp4 (+ (/ (+ temp4 90) 2) (* 45 (- param1 2))))
				(= temp2 (SinMult temp4 100))
				(= temp3 (- (CosMult temp4 100)))
			)
		)
		(= temp5 (/ temp5 5))
		(while
		(and (< (Abs temp3) temp5) (< (Abs temp2) temp5))
			(= temp2 (* temp2 5))
			(= temp3 (* temp3 5))
		)
		(if (and (= temp7 (global2 sel_259?)) global67)
			(= temp6
				(AvoidPath
					sel_1
					sel_0
					(+ sel_1 temp2)
					(+ sel_0 temp3)
					(temp7 sel_24?)
					(temp7 sel_86?)
					0
				)
			)
			(= temp2 (- (proc999_6 temp6 2) sel_1))
			(= temp3 (- (proc999_6 temp6 3) sel_0))
			(Memory 3 temp6)
		)
		(cond 
			((or temp2 temp3) (self sel_312: PolyPath (+ sel_1 temp2) (+ sel_0 temp3)))
			(param1 (self sel_312: 0 sel_253: (* (- param1 1) 45)))
			(else (self sel_312: 0))
		)
	)
	
	(method (sel_253 theSel_55 param2)
		(if argc (= sel_55 theSel_55))
		(if sel_59
			(sel_59
				sel_57: self sel_55 (if (>= argc 2) param2 else 0)
			)
		else
			(DirLoop self sel_55)
			(if (and (>= argc 2) (IsObject param2))
				(param2 sel_145: &rest)
			)
		)
		(return sel_55)
	)
)
